CREATE TABLE `customer_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表索引编号',
  `account_name` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '个人邮箱',
  `nick_name` varchar(30) NOT NULL COMMENT '昵称',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别：MEN男/WOMEN女',
  `phone_no` varchar(20) DEFAULT NULL COMMENT '个人号码',
  `status` varchar(10) NOT NULL COMMENT '状态：初始待验证INIT/生效VALID/冻结FREEZE/注销CANCEL',
  `inst_date` varchar(10) NOT NULL COMMENT '初始写入日期',
  `inst_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '初始写入时间',
  `lupd_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `customer_account_account_name` (`account_name`) USING BTREE,
  UNIQUE KEY `customer_account_email` (`email`) USING BTREE,
  KEY `customer_account_phone_no` (`phone_no`) USING BTREE,
  KEY `customer_account_inst_date` (`inst_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户--账号表';

CREATE TABLE `customer_account_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表索引编号',
  `operate_type` varchar(10) NOT NULL COMMENT '操作类型：修改UPDATE/冻结FREEZE/解冻UNFREEZE/注销CANCEL',
  `account_id` int(11) NOT NULL COMMENT '账号索引编号',
  `account_name` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '个人邮箱',
  `nick_name` varchar(30) NOT NULL COMMENT '昵称',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别：MEN男/WOMEN女',
  `phone_no` varchar(20) DEFAULT NULL COMMENT '个人号码',
  `status` varchar(10) NOT NULL COMMENT '状态：初始待验证INIT/生效VALID/冻结FREEZE/注销CANCEL',
  `memo` varchar(100) DEFAULT NULL COMMENT '操作备注',
  `inst_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '写入时间',
  PRIMARY KEY (`history_id`),
  KEY `customer_account_history_account_id` (`account_id`) USING BTREE,
  KEY `customer_account_history_account_name` (`account_name`) USING BTREE,
  KEY `customer_account_history_operate_type` (`operate_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户--账号变更历史表';

CREATE TABLE `customer_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表索引编号',
  `account_id` int(11) NOT NULL COMMENT '账号索引编号',
  `source_system` varchar(30) NOT NULL COMMENT '来源系统BLOG/ASSISTANT/FORUM/MICROVIEDO...',
  `network_address` varchar(20) NOT NULL COMMENT '网络地址',
  `real_place` varchar(30) DEFAULT NULL COMMENT '现实地址',
  `terminal_type` varchar(10) NOT NULL COMMENT '登陆终端类型PC/IOS/ANDROID/...',
  `equipment_identity` varchar(30) NOT NULL COMMENT '登陆终端设备号',
  `status` varchar(10) NOT NULL COMMENT '状态：在线ON_LINE/离线OFF_LINE/已登出LOGOUT',
  `login_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登陆时间',
  `invalid_datetime` timestamp NULL DEFAULT NULL COMMENT '登陆过期时间',
  PRIMARY KEY (`login_id`),
  KEY `customer_login_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户--当前登陆表';

CREATE TABLE `customer_login_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表索引编号',
  `login_id` int(11) NOT NULL COMMENT '登陆索引编号',
  `account_id` int(11) NOT NULL COMMENT '账号索引编号',
  `source_system` varchar(30) NOT NULL COMMENT '来源系统BLOG/ASSISTANT/FORUM/MICROVIEDO...',
  `network_address` varchar(20) NOT NULL COMMENT '网络地址',
  `real_place` varchar(30) DEFAULT NULL COMMENT '现实地址',
  `terminal_type` varchar(10) NOT NULL COMMENT '登陆终端类型PC/IOS/ANDROID/...',
  `equipment_identity` varchar(30) NOT NULL COMMENT '登陆终端设备号',
  `status` varchar(10) NOT NULL COMMENT '状态：在线ON_LINE/离线OFF_LINE/已登出LOGOUT',
  `login_datetime` timestamp NOT NULL COMMENT '登陆时间',
  `invalid_datetime` timestamp NULL DEFAULT NULL COMMENT '登陆过期时间',
  `logout_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登出时间',
  PRIMARY KEY (`history_id`),
  KEY `customer_login_history_login_id` (`login_id`) USING BTREE,
  KEY `customer_login_history_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户--登陆历史表';

CREATE TABLE `sms_email` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表索引编号',
  `subject` varchar(50) NOT NULL COMMENT '邮件主题:VERIFICATION_CODE/..',
  `email_from` varchar(50) NOT NULL COMMENT '发送者邮箱',
  `email_to` varchar(50) NOT NULL COMMENT '接收者邮箱',
  `text` varchar(500) NOT NULL COMMENT '邮件内容',
  `template` varchar(50) DEFAULT NULL COMMENT '邮件模板名',
  `template_variables` varchar(200) DEFAULT NULL COMMENT '模板变量',
  `attachments` varchar(200) DEFAULT NULL COMMENT '附件列表',
  `inlines` varchar(200) DEFAULT NULL COMMENT '静态资源列表',
  `status` varchar(20) NOT NULL COMMENT '状态：成功SUCCESS/失败FAILURE/异常EXCEPTION/确认成功CONFIRM_SUCCESS/确认失败CONFIRM_FAILURE',
  `inst_date` varchar(10) NOT NULL COMMENT '写入日期',
  `inst_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '写入时间',
  `lupd_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`email_id`),
  KEY `sms_email_subject` (`subject`) USING BTREE,
  KEY `sms_email_email_to` (`email_to`) USING BTREE,
  KEY `sms_email_status` (`status`) USING BTREE,
  KEY `sms_email_inst_date` (`inst_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短讯--邮件表';