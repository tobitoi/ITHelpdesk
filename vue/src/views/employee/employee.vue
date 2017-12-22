<template>
  <div class="app-container">
    <div class="filter-container">
      <el-form>
              <el-form-item>
                <el-button type="primary" icon="plus" @click="showCreate" v-if="hasPerm('employee:add')">Create
                </el-button>
              </el-form-item>
            </el-form>
    </div>
    <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit
              highlight-current-row>
      <el-table-column align="center" label="No" width="80">
        <template slot-scope="scope">
          <span v-text="getIndex(scope.$index)"> </span>
        </template>
      </el-table-column>
      <el-table-column align="center" label=" Id" prop="id" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="User Id" prop="user_id" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="Username" prop="name" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="gender" prop="gender" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="street" prop="street" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="department Id" prop="dept_id" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="badge number" prop="badge_number" style="width: 60px;"></el-table-column>
      <el-table-column align="center" label="Action" width="220" v-if="hasPerm('employee:update')">
        <template slot-scope="scope">
          <el-button type="primary" icon="edit" @click="showUpdate(scope.$index)">Edit</el-button>
          <el-button type="danger" icon="delete" v-if="scope.row.userId!=userId "
                     @click="removeUser(scope.$index)">Remove
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="listQuery.pageNum"
      :page-size="listQuery.pageRow"
      :total="totalCount"
      :page-sizes="[10, 20, 50, 100]"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form class="small-space" :model="tempEmployee" label-position="left" label-width="80px"
               style='width: 300px; margin-left:50px;'>
        <el-form-item label="username" required>
          <el-input type="text" v-model="tempEmployee.userId">
          </el-input>
        </el-form-item>
        <el-form-item label="name"  required>
          <el-input type="text" v-model="tempEmployee.name">
          </el-input>
        </el-form-item>
        <el-form-item label="gender" required>
          <el-input type="text" v-model="tempEmployee.gender">
          </el-input>
        </el-form-item>
        <el-form-item label="street" required>
          <el-input type="text" v-model="tempEmployee.street">
          </el-input>
        </el-form-item>
        <el-form-item label="department " required>
          <el-input type="text" v-model="tempEmployee.deptId">
          </el-input>
        </el-form-item>
        <el-form-item label="Badge Number " required>
          <el-input type="text" v-model="tempEmployee.badgeNumber">
          </el-input>
        </el-form-item>
       </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="createEmployee">Create</el-button>
        <el-button type="primary" v-else @click="updateEmployee">Modify</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        totalCount: 0, //分页组件--数据总条数
        list: [],//表格的数据
        listLoading: false,//数据加载等待动画
        listQuery: {
          pageNum: 1,//页码
          pageRow: 50,//每页条数
          name: ''
        },
        dialogStatus: 'create',
        dialogFormVisible: false,
        textMap: {
          update: '编辑',
          create: '创建文章'
        },
        tempEmployee: {
         userId: '',
         deptId: '',
         name: '',
         gender: '',
         street: '',
         badgeNumber: ''
        }
      }
    },
    created() {
      this.getList();
    },
    methods: {
      getList() {
        //查询列表
        if (!this.hasPerm('employee:list')) {
          return
        }
        this.listLoading = true;
        this.api({
          url: "/employee/listEmployee",
          method: "get",
          params: this.listQuery
        }).then(data => {
          this.listLoading = false;
          this.list = data.list;
          this.totalCount = data.totalCount;
        })
      },
      handleSizeChange(val) {
        //改变每页数量
        this.listQuery.pageRow = val
        this.handleFilter();
      },
      handleCurrentChange(val) {
        //改变页码
        this.listQuery.pageNum = val
        this.getList();
      },
      getIndex($index) {
        //表格序号
        return (this.listQuery.pageNum - 1) * this.listQuery.pageRow + $index + 1
      },
      showCreate() {
        //显示新增对话框
        this.tempEmployee.userId = "";
        this.tempEmployee.deptId = "";
        this.tempEmployee.name = "";
        this.tempEmployee.street = "";
        this.tempEmployee.gender = "";
        this.tempEmployee.badgeNumber = "";
        this.dialogStatus = "create"
        this.dialogFormVisible = true
      },
      showUpdate($index) {
        //显示修改对话框
        let employee = this.list[$index];
        this.tempEmployee.name = employee.name;
        this.tempEmployee.userId = employee.user_id;
        this.tempEmployee.gender = employee.gender;
        this.tempEmployee.street = employee.street;
        this.tempEmployee.deptId = employee.dept_id;
        this.tempEmployee.badgeNumber = employee.badge_number;
        this.dialogStatus = "update"
        this.dialogFormVisible = true
      },
      createEmployee() {
        //保存新文章
        this.api({
          url: "/employee/addEmployee",
          method: "post",
          data: this.tempEmployee
        }).then(() => {
          this.getList();
          this.dialogFormVisible = false
        })
      },
      updateEmployee() {
        //修改文章
        this.api({
          url: "/employee/updateEmployee",
          method: "post",
          data: this.tempEmployee
        }).then(() => {
          this.getList();
          this.dialogFormVisible = false
        })
      },
    }
  }
</script>
