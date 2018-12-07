-- ----------------------------
--  用户信息表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `name` varchar(255)  DEFAULT NULL COMMENT '姓名',
  `gender` char(1) COMMENT '性别. M-男,F-女,U-未知',
  `id_card` varchar(64) COMMENT '身份证.加密',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `real_name_status` char(1) COMMENT '实名标识.Y-实名;N-未实名;U-未知',
  `email` varchar(128)  DEFAULT NULL COMMENT '邮箱',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户信息表';