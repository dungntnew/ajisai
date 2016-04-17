set foreign_key_checks=0;
drop table if exists `flowers`;
drop table if exists `customers`;
drop table if exists `orders`;

create table `flowers` (
  `id` bigint(20) not null auto_increment,
  `name` varchar(255) default null,
  `start_date` varchar(255) default null,
  primary key (`id`)
) engine=InnoDB default charset=utf8;

create table `customers` (
  `customer_id` bigint(20) not null auto_increment,
  `name` varchar(255) default null,
  primary key (`customer_id`)
) engine=InnoDB default charset=utf8;

create table `orders` (
  `order_id` bigint(20) not null auto_increment,
  `order_date` varchar(255) default null,
  `customer_id` bigint(20) not null,
  primary key (`order_id`),
  index `fk_order_customer` (`customer_id` ASC),
  constraint `fk_order_customer`
  foreign key (`customer_id`)
  references `customers`(`customer_id`)
  on delete no action
  on update no action
) engine=InnoDB default charset=utf8;

set foreign_key_checks=1;