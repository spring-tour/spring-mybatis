-- 用户表
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(100) NOT NULL COMMENT '用户主键',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phoneNo` varchar(20) DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `registerFrom` varchar(50) DEFAULT NULL COMMENT '注册来源',
  `registerIp` varchar(50) DEFAULT NULL COMMENT '注册IP',
  `registerTime` datetime DEFAULT NULL COMMENT '注册时间',
  `loginTimes` int(11) DEFAULT NULL COMMENT '登录次数',
  `status` int(11) DEFAULT '0' COMMENT '用户状态（0：正常）',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UDX_ID` (`id`) USING BTREE,
  KEY `IDX_USERNAME` (`username`) USING BTREE,
  KEY `IDX_EMAIL` (`email`) USING BTREE,
  KEY `IDX_IPHONE_NO` (`phoneNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- admin
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` varchar(100) NOT NULL COMMENT '用户主键',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phoneNo` varchar(20) DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `role` int(11) DEFAULT '0' COMMENT '用户角色（0：admin, 1:一般用户）',
  `registerTime` datetime DEFAULT NULL COMMENT '注册时间',
  `loginTimes` int(11) DEFAULT NULL COMMENT '登录次数',
  `status` int(11) DEFAULT '0' COMMENT '用户状态（0：正常）',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UDX_ID` (`id`) USING BTREE,
  KEY `IDX_USERNAME` (`username`) USING BTREE,
  KEY `IDX_EMAIL` (`email`) USING BTREE,
  KEY `IDX_IPHONE_NO` (`phoneNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- t_daily_article 每日一文
DROP TABLE IF EXISTS `t_daily_article`;
CREATE TABLE `t_daily_article` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `author` varchar(100) DEFAULT NULL COMMENT '作者',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `firstParagraph` text COMMENT '文章首段',
  `content` text COMMENT '文章内容',
  `status` int(11) DEFAULT '0' COMMENT '状态（0：正常）',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `IDX_AUTHOR` (`author`) USING BTREE,
  KEY `IDX_TITLE` (`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;