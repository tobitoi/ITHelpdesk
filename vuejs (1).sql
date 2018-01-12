-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 12 Jan 2018 pada 15.22
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vuejs`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT '',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1',
  `ticket` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发布号作者表';

--
-- Dumping data untuk tabel `article`
--

INSERT INTO `article` (`id`, `content`, `create_time`, `update_time`, `delete_status`, `ticket`) VALUES
(28, '555', '2018-01-12 08:41:43', '2018-01-12 09:01:22', '1', ''),
(29, 'tes', '2018-01-12 09:00:59', '2018-01-12 09:00:59', '1', ''),
(30, 'testt', '2018-01-12 09:01:03', '2018-01-12 09:01:03', '1', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `employee`
--

INSERT INTO `employee` (`id`, `gender`, `name`, `street`, `user_id`) VALUES
(1, 'Man', 'Theo', 'sreet', 1),
(2, 'Man', 'Dio Alif Pamungkas', 'street', 2),
(3, 'Man', 'Almakmur', 'street', 3),
(4, 'Man', 'Muhammad Haryadi', 'street', 4),
(5, 'L', 'name', 'andi', 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `problems`
--

CREATE TABLE `problems` (
  `id` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `problems`
--

INSERT INTO `problems` (`id`, `kode`, `description`) VALUES
(1, 'PBKOMPTI', 'Kerusakan Komputer IT'),
(2, 'PBKOMOCC', 'Kerusakan Komputer OCC'),
(3, 'VCS', 'VMT can\'t start');

-- --------------------------------------------------------

--
-- Struktur dari tabel `procces`
--

CREATE TABLE `procces` (
  `id` int(11) NOT NULL,
  `kode` varchar(5) NOT NULL,
  `description` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `procces`
--

INSERT INTO `procces` (`id`, `kode`, `description`) VALUES
(1, 'WT', 'Waiting Sparepart'),
(2, 'OP', 'On Proccess'),
(3, 'OTB', 'On Take Back');

-- --------------------------------------------------------

--
-- Struktur dari tabel `quality_control`
--

CREATE TABLE `quality_control` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `date_start` varchar(30) NOT NULL,
  `tools_id` int(11) NOT NULL,
  `problem` varchar(255) NOT NULL,
  `repair_desc` varchar(255) NOT NULL,
  `date_finish` varchar(30) NOT NULL,
  `reporter` varchar(50) NOT NULL,
  `verify_status` varchar(50) NOT NULL,
  `delete_status` int(11) NOT NULL DEFAULT '1',
  `timediff` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `quality_control`
--

INSERT INTO `quality_control` (`id`, `employee_id`, `date_start`, `tools_id`, `problem`, `repair_desc`, `date_finish`, `reporter`, `verify_status`, `delete_status`, `timediff`) VALUES
(1, 1, '2018-01-08 00:40:00', 29, 'VMT Hang', 'Restore', '2018-01-08 00:50:00', 'Anwar', 'Done', 1, ''),
(2, 2, '2017-12-19 09:14:00', 23, 'VMT Windows Error', 'Restore VMT', '2017-12-19 09:26:00', 'RTG11', 'Done', 1, ''),
(3, 3, '2017-12-19 09:20:00', 25, 'VMT tidak menyala', 'Ganti adaptor / pasang kembali adaptor pada VMT', '2017-12-19 09:40:00', 'RTG13', 'Done', 1, ''),
(4, 3, '2017-12-19 09:20:00', 25, 'VMT tidak menyala', 'Ganti adaptor / pasang kembali adaptor pada VMT', '2017-12-19 09:40:00', 'RTG13', 'Done', 1, ''),
(5, 3, '2017-12-19 09:20:00', 25, 'VMT tidak menyala', 'Ganti adaptor / pasang kembali adaptor pada VMT', '2017-12-19 09:40:00', 'RTG13', 'Done', 1, ''),
(6, 4, '2018-01-04 10:10:00', 7, 'VMT hang', 'restore vmt', '2018-01-04 10:40:00', 'RTG10', 'Done', 1, ''),
(7, 4, '2018-01-08T12:20:50.000Z', 2, 'aa', 'aa', '2018-01-08 12:20:58', 'aaaa', 'Cannot Fix', 1, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `reporter`
--

CREATE TABLE `reporter` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `tools_id` int(11) NOT NULL,
  `problems_id` int(11) NOT NULL,
  `confirm` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `reporter`
--

INSERT INTO `reporter` (`id`, `name`, `date`, `tools_id`, `problems_id`, `confirm`) VALUES
(1, 'Anwar', '2018-01-10, 23:25:03', 20, 3, 1),
(2, 'tes', '2018-01-10, 23:47:10', 1, 1, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `sparepart`
--

CREATE TABLE `sparepart` (
  `id` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `sparepart`
--

INSERT INTO `sparepart` (`id`, `kode`, `name`) VALUES
(1, 'HDD', 'Hard Disk'),
(2, 'MOBO', 'MotherBoard'),
(3, 'VMTBATT', 'Battery VMT');

-- --------------------------------------------------------

--
-- Struktur dari tabel `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `status`
--

INSERT INTO `status` (`id`, `status`) VALUES
(1, 'Ready'),
(2, 'Broken'),
(3, 'Maintenance');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sys_permission`
--

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0',
  `menu_code` varchar(255) DEFAULT '',
  `menu_name` varchar(255) DEFAULT '',
  `permission_code` varchar(255) DEFAULT '',
  `permission_name` varchar(255) DEFAULT '',
  `required_permission` tinyint(1) DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台权限表' ROW_FORMAT=COMPACT;

--
-- Dumping data untuk tabel `sys_permission`
--

INSERT INTO `sys_permission` (`id`, `menu_code`, `menu_name`, `permission_code`, `permission_name`, `required_permission`) VALUES
(101, 'article', 'Article management', 'article:list', 'list Article', 1),
(102, 'article', 'Article management', 'article:add', 'Add Article', 2),
(103, 'article', 'Article management', 'article:update', 'Update Article', 2),
(201, 'employee', 'employee management', 'employee:list', 'List Employee', 1),
(202, 'employee', 'employee management', 'employee:add', 'Add Employee', 2),
(203, 'employee', 'employee management', 'employee:update', 'Update Employee', 2),
(301, 'tools category', 'tools category', 'toolsCategory:list', 'list Tools Category', 1),
(302, 'tools category', 'tools category', 'toolsCategory:add', 'add Tools Category', 2),
(303, 'tools category', 'tools category', 'toolsCategory:update', 'update Tools Category', 2),
(304, 'tools category', 'tools category', 'toolsCategory:delete', 'Delete Tools Category', 2),
(401, 'tools', 'tools management', 'tools:list', 'list Tools', 1),
(402, 'tools', 'tools management', 'tools:add', 'add Tools', 2),
(403, 'tools', 'tools management', 'tools:update', 'Update Tools', 2),
(501, 'quality', 'quality control', 'quality:list', 'List Quality', 1),
(502, 'quality', 'quality control', 'quality:add', 'Add Quality', 2),
(503, 'quality', 'quality control', 'quality:update', 'Update Quality', 2),
(601, 'user', 'User', 'user:list', 'List User', 1),
(602, 'user', 'User', 'user:add', 'Add User', 2),
(603, 'user', 'User', 'user:update', 'Update User', 2),
(701, 'role', 'Role Permissions', 'role:list', 'List Role', 1),
(702, 'role', 'Role Permissions', 'role:add', 'Add Role', 2),
(703, 'role', 'Role Permissions', 'role:update', 'Uptade Role', 2),
(704, 'role', 'Role Permissions', 'role:delete', 'Delete Role', 2),
(801, 'problems', 'Problems Management', 'problems:list', 'List Problems', 1),
(802, 'problems', 'Problems Management', 'problems:add', 'Add Problems', 2),
(803, 'problems', 'Problems Management', 'problems:update', 'Update Problems', 2),
(901, 'sparepart', 'Sparepart Management', 'sparepart:list', 'List SparePart', 1),
(902, 'sparepart', 'Sparepart Management', 'sparepart:add', 'Add Sparepart', 2),
(903, 'sparepart', 'Sparepart Management', 'sparepart:update', 'Update Sparepart', 2),
(1001, 'procces', 'Proccess Management', 'proccess:list', 'List Proccess', 1),
(1002, 'procces', 'Proccess Management', 'proccess:add', 'Add Proccess', 2),
(1003, 'procces', 'Proccess Management', 'proccess:update', 'Update Proccess', 2),
(1011, 'Reporter', 'Reporter', 'reporter:list', 'List Reporter', 1),
(1012, 'Reporter', 'Reporter', 'reporter:add', 'Add Reporter', 2),
(1013, 'Reporter', 'Reporter', 'reporter:update', 'Update Reporter', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `sys_role`
--

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台角色表' ROW_FORMAT=COMPACT;

--
-- Dumping data untuk tabel `sys_role`
--

INSERT INTO `sys_role` (`id`, `role_name`, `create_time`, `update_time`, `delete_status`) VALUES
(1, 'administrator', '2017-11-22 08:24:34', '2017-12-21 13:54:00', '1'),
(2, 'Reporter', '2017-11-22 08:24:34', '2018-01-10 16:29:30', '2'),
(3, 'Programmer', '2017-11-22 08:28:47', '2017-12-21 13:54:33', '1'),
(4, 'tes', '2017-12-21 17:50:14', '2018-01-10 15:44:32', '2'),
(5, 'Reporter', '2018-01-10 16:29:44', '2018-01-10 16:29:44', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sys_role_permission`
--

CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

--
-- Dumping data untuk tabel `sys_role_permission`
--

INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `delete_status`) VALUES
(75, 5, 1011, '2018-01-11 07:46:05', '2018-01-11 07:46:05', '1'),
(76, 5, 1013, '2018-01-11 07:46:05', '2018-01-11 07:46:05', '1'),
(77, 5, 1012, '2018-01-11 07:46:05', '2018-01-11 07:46:05', '1'),
(78, 5, 401, '2018-01-11 07:48:30', '2018-01-11 07:48:30', '1'),
(79, 5, 801, '2018-01-11 07:48:30', '2018-01-11 07:48:30', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sys_user`
--

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营后台用户表';

--
-- Dumping data untuk tabel `sys_user`
--

INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `role_id`, `create_time`, `update_time`, `delete_status`) VALUES
(10003, 'admin', '123456', 'coba11', 1, '2017-10-30 03:52:38', '2017-12-30 16:19:09', '1'),
(10004, 'user', '123456', 'user1', 2, '2017-10-30 08:13:02', '2018-01-10 16:27:29', '2'),
(10005, 'aaa', '123456', 'abba', 1, '2017-11-15 06:02:56', '2017-12-30 15:34:48', '2'),
(10007, 'test', '123456', 'tobitoi', 3, '2017-11-22 08:29:41', '2017-12-21 16:26:07', '1'),
(10008, 'tes', '123456', 'tes', 4, '2017-12-21 17:50:36', '2018-01-10 12:38:06', '2'),
(10010, 'reporter', '123456', 'reporter', 5, '2018-01-10 16:30:21', '2018-01-10 16:30:21', '1'),
(10011, 'Confirm', '123456', 'ttt', 3, '2018-01-12 03:46:56', '2018-01-12 03:46:56', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tools`
--

CREATE TABLE `tools` (
  `id` int(11) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `host_name` varchar(20) NOT NULL,
  `ip_address` varchar(15) NOT NULL,
  `serial_number` varchar(30) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) NOT NULL DEFAULT '1',
  `category_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tools`
--

INSERT INTO `tools` (`id`, `merk`, `host_name`, `ip_address`, `serial_number`, `create_time`, `update_time`, `delete_status`, `category_id`, `status_id`) VALUES
(1, 'Honeywell', 'HHT 03', '192.168.0.180', 'MX9130535514', '2018-01-02 02:54:23', '2018-01-07 14:18:10', '1', 1, 1),
(2, 'Honeywell', 'HHT 04', '192.168.0.181', 'MX9124317692', '2018-01-03 13:15:20', '2018-01-07 14:05:00', '1', 1, 2),
(3, 'Honeywell', 'HHT 06', '192.168.0.183', 'MX9130535505', '2018-01-04 12:05:21', '2018-01-07 14:05:02', '1', 1, 3),
(4, 'Honeywell', 'HHT 07', '192.168.0.184', 'MX9130535499', '2018-01-07 11:45:42', '2018-01-07 14:22:36', '1', 1, 2),
(5, 'Honeywell', 'HHT 08', '192.168.0.185', 'MX9130535503', '2018-01-07 11:46:53', '2018-01-07 14:22:42', '1', 1, 3),
(6, 'Honeywell', 'HHT 09', '192.168.0.186', 'MX9130535517', '2018-01-07 11:48:22', '2018-01-07 14:05:46', '1', 1, 1),
(7, 'Honeywell', 'HHT 10', '192.168.0.187', 'MX9130535512', '2018-01-07 11:49:33', '2018-01-07 14:05:48', '1', 1, 1),
(8, 'Honeywell', 'HHT 11', '192.168.0.188', 'MX9130535506', '2018-01-07 11:50:44', '2018-01-07 14:05:50', '1', 1, 1),
(9, 'Honeywell', 'HHT 13', '192.168.0.190', 'MX9130535496', '2018-01-07 11:54:50', '2018-01-07 14:05:52', '1', 1, 1),
(10, 'Honeywell', 'HHT 14', '192.168.0.191', 'MX9130535491', '2018-01-07 11:59:32', '2018-01-07 14:06:33', '1', 1, 1),
(11, 'Honeywell', 'HHT15', '192.168.0.192', 'MX9150906701', '2018-01-07 12:00:40', '2018-01-07 14:06:35', '1', 1, 1),
(12, 'Honeywell', 'HHT 16', '192.168.0.193', 'MX9150906694', '2018-01-07 12:04:43', '2018-01-07 14:06:41', '1', 1, 1),
(13, 'Honeywell', 'RTG 01', '192.168.0.118', 'VX9B152313636', '2018-01-07 12:12:07', '2018-01-07 14:06:44', '1', 2, 1),
(14, 'Honeywell', 'RTG 02', '192.168.0.119', 'VX9B152313472', '2018-01-07 12:13:28', '2018-01-07 14:06:46', '1', 2, 1),
(15, 'Honeywell', 'RTG 03', '192.168.0.120', 'VX9B152313632', '2018-01-07 12:15:08', '2018-01-07 14:06:48', '1', 2, 1),
(16, 'Honeywell', 'RTG 04', '192.168.0.121', 'VX9B152313637', '2018-01-07 12:17:00', '2018-01-07 14:06:51', '1', 2, 1),
(17, 'Honeywell', 'RTG 05', '192.168.0.122', 'VX9B152313474', '2018-01-07 12:19:17', '2018-01-07 14:06:53', '1', 2, 1),
(18, 'Honeywell', 'RTG 06', '192.168.0.123', 'VX9B152313634', '2018-01-07 12:20:44', '2018-01-07 14:06:56', '1', 2, 1),
(19, 'Honeywell', 'RTG 07', '192.168.0.124', 'VX9B152313470', '2018-01-07 12:25:18', '2018-01-07 14:06:58', '1', 2, 1),
(20, 'Honeywell', 'RTG 08', '192.168.0.125', 'VX9B152714831', '2018-01-07 12:26:40', '2018-01-07 14:07:01', '1', 2, 1),
(21, 'Honeywell', 'RTG 09', '192.168.0.126', 'VX9B152313469', '2018-01-07 12:27:37', '2018-01-07 14:07:04', '1', 2, 1),
(22, 'Honeywell', 'RTG 10', '192.168.0.127', 'VX9B152313635', '2018-01-07 12:28:50', '2018-01-07 14:07:06', '1', 2, 1),
(23, 'Honeywell', 'RTG 11', '192.168.0.128', 'VX9B152313473', '2018-01-07 12:30:00', '2018-01-07 14:07:08', '1', 2, 1),
(24, 'Honeywell', 'RTG 12', '192.168.0.129', 'VX9B152313633', '2018-01-07 12:31:18', '2018-01-07 14:07:10', '1', 2, 1),
(25, 'Honeywell', 'RTG 13', '192.168.0.130', 'VX9B152313471', '2018-01-07 12:57:45', '2018-01-07 14:07:12', '1', 2, 1),
(26, 'Honeywell', 'RTG 14', '192.168.0.131', 'VX9B152313466', '2018-01-07 12:59:12', '2018-01-07 14:07:22', '1', 2, 1),
(27, 'Honeywell', 'RTG 15', '192.168.0.132', 'VX9B152714830', '2018-01-07 13:00:09', '2018-01-07 14:07:25', '1', 2, 1),
(28, 'Honeywell', 'RTG 16', '192.168.0.133', 'VX9B152313467', '2018-01-07 13:01:04', '2018-01-07 14:07:27', '1', 2, 1),
(29, 'Honeywell', 'RTG 17', '192.168.0.134', 'VX9B152313475', '2018-01-07 13:02:05', '2018-01-07 14:07:29', '1', 2, 1),
(30, 'Honeywell', 'RTG 18', '192.168.0.135', 'VX9B152313477', '2018-01-07 13:02:51', '2018-01-07 14:07:31', '1', 2, 1),
(31, 'Honeywell', 'HT 05', '192.168.0.145', 'VM1C153606276', '2018-01-07 13:06:35', '2018-01-07 14:07:33', '1', 3, 1),
(32, 'Honeywell', 'HT 06', '192.168.0.146', 'VM1C153606283', '2018-01-07 13:07:27', '2018-01-07 14:07:35', '1', 3, 1),
(33, 'Honeywell', 'HT 07', '192.168.0.147', 'VM1C153606283', '2018-01-07 13:08:30', '2018-01-07 14:07:37', '1', 3, 1),
(34, 'Honeywell', 'HT 08', '192.168.0.148', 'VM1C153606280', '2018-01-07 13:09:13', '2018-01-07 14:07:40', '1', 3, 1),
(35, 'Honeywell', 'HT 09', '192.168.0.149', 'VM1C153606297', '2018-01-07 13:10:18', '2018-01-07 14:07:42', '1', 3, 1),
(36, 'Honeywell', 'HT 10', '192.168.0.151', 'VM1C153606266', '2018-01-07 13:11:13', '2018-01-07 14:07:43', '1', 3, 1),
(37, 'Honeywell', 'HT 11', '192.168.0.152', 'VM1C153606627', '2018-01-07 13:12:13', '2018-01-07 14:07:45', '1', 3, 1),
(38, 'Honeywell', 'HT 12', '192.168.0.153', 'VM1C153606272', '2018-01-07 13:13:18', '2018-01-07 14:07:47', '1', 3, 1),
(39, 'Honeywell', 'HT 13', '192.168.0.154', 'VM1C153606291', '2018-01-07 13:14:04', '2018-01-07 14:07:49', '1', 3, 1),
(40, 'Honeywell', 'HT 14', '192.168.0.155', 'VM1C153606273', '2018-01-07 13:15:06', '2018-01-07 14:07:52', '1', 3, 1),
(41, 'Honeywell', 'HT 15', '192.168.0.156', 'VM1C153606284', '2018-01-07 13:15:44', '2018-01-07 14:07:54', '1', 3, 1),
(42, 'Honeywell', 'HT 16', '192.168.0.157', 'VM1C153606289', '2018-01-07 13:16:24', '2018-01-07 14:07:56', '1', 3, 1),
(43, 'Honeywell', 'HT 17', '192.168.0.158', 'VM1C153606290', '2018-01-07 13:17:05', '2018-01-07 14:07:58', '1', 3, 1),
(44, 'Honeywell', 'HT 18', '192.168.0.159', 'VM1C153606265', '2018-01-07 13:17:54', '2018-01-07 14:08:00', '1', 3, 1),
(45, 'Honeywell', 'HT 19', '192.168.0.160', 'VM1C153606279', '2018-01-07 13:18:36', '2018-01-07 14:08:02', '1', 3, 1),
(46, 'Honeywell', 'HT 20', '192.168.0.161', 'VM1C153606316', '2018-01-07 13:19:35', '2018-01-07 14:08:05', '1', 3, 1),
(47, 'Honeywell', 'HT 21', '192.168.0.162', 'VM1C153606278', '2018-01-07 13:20:21', '2018-01-07 14:08:08', '1', 3, 1),
(48, 'Honeywell', 'HT 22', '192.168.0.163', 'VM1C153606277', '2018-01-07 13:20:59', '2018-01-07 14:08:11', '1', 3, 1),
(49, 'Honeywell', 'HT 23', '192.168.0.164', 'VM1C153606271', '2018-01-07 13:21:52', '2018-01-07 14:08:13', '1', 3, 1),
(50, 'Honeywell', 'HT 24', '192.168.0.165', 'VM1C153606268', '2018-01-07 13:22:29', '2018-01-07 14:08:15', '1', 3, 1),
(51, 'Honeywell', 'HT 25', '192.168.0.166', 'VM1C153606267', '2018-01-07 13:23:20', '2018-01-07 14:08:17', '1', 3, 1),
(52, 'Honeywell', 'HT 26', '192.168.0.167', 'VM1C153606264', '2018-01-07 13:24:06', '2018-01-07 14:08:20', '1', 3, 1),
(53, 'Honeywell', 'HT 27', '192.168.0.169', 'VM1C153605281', '2018-01-07 13:25:46', '2018-01-07 14:08:22', '1', 3, 1),
(54, 'Honeywell', 'HT 28', '192.168.0.200', 'VM1C153606266', '2018-01-07 13:26:46', '2018-01-07 14:08:24', '1', 3, 1),
(55, 'Honeywell', 'HT 29', '192.168.0.202', 'VM1C153606287', '2018-01-07 13:27:25', '2018-01-07 14:08:26', '1', 3, 1),
(56, 'Honeywell', 'HT 30', '192.168.0.201', 'VM1C153606288', '2018-01-07 13:28:09', '2018-01-07 14:08:28', '1', 3, 1),
(57, 'Honeywell', 'HT 31', '192.168.0.141', 'VM1C153606270', '2018-01-07 13:28:48', '2018-01-07 14:08:30', '1', 3, 1),
(58, 'Honeywell', 'HT 32', '192.168.0.142', 'VM1C153606285', '2018-01-07 13:29:40', '2018-01-07 14:08:32', '1', 3, 1),
(59, 'Honeywell', 'HT 33', '192.168.0.143', 'VM1C153606295', '2018-01-07 13:30:24', '2018-01-07 14:08:34', '1', 3, 1),
(60, 'Honeywell', 'HT 34', '192.168.0.144', 'VM1C153606679', '2018-01-07 13:31:01', '2018-01-07 14:08:36', '1', 3, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `toolsCategory`
--

CREATE TABLE `toolsCategory` (
  `id` int(11) NOT NULL,
  `category` varchar(24) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) CHARACTER SET utf8 NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `toolsCategory`
--

INSERT INTO `toolsCategory` (`id`, `category`, `create_time`, `update_time`, `delete_status`) VALUES
(1, 'HHT', '2017-12-30 15:41:46', '2017-12-30 16:27:48', '1'),
(2, 'VMT', '2017-12-30 16:29:44', '2017-12-30 16:30:00', '1'),
(3, 'PAGEER', '2017-12-30 17:21:00', '2018-01-05 14:03:26', '1'),
(4, 'ANTEN', '2018-01-07 11:39:15', '2018-01-07 11:39:15', '1'),
(5, 'Komputer', '2018-01-10 12:29:13', '2018-01-10 12:29:13', '1'),
(6, 'Printer', '2018-01-10 12:29:19', '2018-01-10 12:29:19', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `problems`
--
ALTER TABLE `problems`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `procces`
--
ALTER TABLE `procces`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quality_control`
--
ALTER TABLE `quality_control`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reporter`
--
ALTER TABLE `reporter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sparepart`
--
ALTER TABLE `sparepart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_permission`
--
ALTER TABLE `sys_permission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_role`
--
ALTER TABLE `sys_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_role_permission`
--
ALTER TABLE `sys_role_permission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tools`
--
ALTER TABLE `tools`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `toolsCategory`
--
ALTER TABLE `toolsCategory`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `problems`
--
ALTER TABLE `problems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `procces`
--
ALTER TABLE `procces`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `quality_control`
--
ALTER TABLE `quality_control`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `reporter`
--
ALTER TABLE `reporter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `sparepart`
--
ALTER TABLE `sparepart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `sys_role`
--
ALTER TABLE `sys_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `sys_role_permission`
--
ALTER TABLE `sys_role_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;
--
-- AUTO_INCREMENT for table `sys_user`
--
ALTER TABLE `sys_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10012;
--
-- AUTO_INCREMENT for table `tools`
--
ALTER TABLE `tools`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT for table `toolsCategory`
--
ALTER TABLE `toolsCategory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
