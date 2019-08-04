drop table if exists `user`;

create table `user`
(
    `id`       int(11) auto_increment not null,
    `nickname` varchar(30) unique     not null,
    `password` varchar(100) default null,
    primary key (`id`)
) engine = InnoDB
  default charset = utf8mb4
  default collate = utf8mb4_general_ci;
