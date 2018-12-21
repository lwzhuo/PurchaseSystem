use purchase;
-- 需求部门
INSERT INTO permission values(1,'needplanform_select_own','查看自己部门的需求计划单');
INSERT INTO permission values(2,'needplanform_select_all','查看所有部门的需求计划单');
INSERT INTO permission values(3,'needplanform_insert','新增需求计划单');
INSERT INTO permission values(4,'needplanform_update_own','修改自己部门需求计划单');
INSERT INTO permission values(5,'needplanform_update_all','修改所有部门需求计划单');
INSERT INTO permission values(6,'needplanform_delete_own','删除自己部门需求计划单');
INSERT INTO permission values(7,'needplanform_delete_all','删除所有部门需求计划单');

INSERT INTO role values(1,'demander_readonly','需求部门只读角色(进针对所属部门)');
INSERT INTO role values(2,'demander_default','需求部门默认角色(仅针对所属部门CRUD)');
INSERT INTO role values(3,'demander_admin','需求部门管理员角色(对于所有部门的CRUD)');

INSERT INTO role_permission values(1,1);
INSERT INTO role_permission values(2,1);
INSERT INTO role_permission values(2,3);
INSERT INTO role_permission values(2,4);
INSERT INTO role_permission values(2,6);
INSERT INTO role_permission values(3,2);
INSERT INTO role_permission values(3,3);
INSERT INTO role_permission values(3,5);
INSERT INTO role_permission values(3,7);

SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='demander_readonly' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='demander_default' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='demander_admin' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;

-- 采购部门
INSERT INTO permission values(8,'purchaseplanform_select','查看采购计划单');
INSERT INTO permission values(9,'purchaseplanform_insert','新增采购计划单');
INSERT INTO permission values(10,'purchaseplanform_update','修改采购计划单');
INSERT INTO permission values(11,'purchaseplanform_delete','删除采购计划单');

INSERT INTO permission values(12,'orderform_select','查看采购订单');
INSERT INTO permission values(13,'orderform_insert','新增采购订单');
INSERT INTO permission values(14,'orderform_update','修改采购订单');
INSERT INTO permission values(15,'orderform_delete','删除采购订单');

INSERT INTO permission values(16,'receiptform_select','查看收货单');
INSERT INTO permission values(17,'receiptform_insert','新增收货单');
INSERT INTO permission values(18,'receiptform_update','修改收货单');
INSERT INTO permission values(19,'receiptform_delete','删除收货单');


INSERT INTO role values(4,'purchase_apartment_readonly','采购部门只读角色');
INSERT INTO role values(5,'purchase_apartment_default','需求部门默认角色CRUD(修改删除只能对自己的表操作)');
INSERT INTO role values(6,'purchase_apartment_admin','采购部门CRUD高级权限(可修改删除其他人的表)');

INSERT INTO role_permission values(4,2);
INSERT INTO role_permission values(4,3);
INSERT INTO role_permission values(4,5);
INSERT INTO role_permission values(4,7);
INSERT INTO role_permission values(4,8);
INSERT INTO role_permission values(4,12);
INSERT INTO role_permission values(4,16);

INSERT INTO role_permission values(5,2);
INSERT INTO role_permission values(5,3);
INSERT INTO role_permission values(5,5);
INSERT INTO role_permission values(5,7);
INSERT INTO role_permission values(5,8);
INSERT INTO role_permission values(5,9);
INSERT INTO role_permission values(5,10);
INSERT INTO role_permission values(5,11);
INSERT INTO role_permission values(5,12);
INSERT INTO role_permission values(5,13);
INSERT INTO role_permission values(5,14);
INSERT INTO role_permission values(5,15);
INSERT INTO role_permission values(5,16);
INSERT INTO role_permission values(5,17);
INSERT INTO role_permission values(5,18);
INSERT INTO role_permission values(5,19);

INSERT INTO role_permission values(6,2);
INSERT INTO role_permission values(6,3);
INSERT INTO role_permission values(6,5);
INSERT INTO role_permission values(6,7);
INSERT INTO role_permission values(6,8);
INSERT INTO role_permission values(6,9);
INSERT INTO role_permission values(6,10);
INSERT INTO role_permission values(6,11);
INSERT INTO role_permission values(6,12);
INSERT INTO role_permission values(6,13);
INSERT INTO role_permission values(6,14);
INSERT INTO role_permission values(6,15);
INSERT INTO role_permission values(6,16);
INSERT INTO role_permission values(6,17);
INSERT INTO role_permission values(6,18);
INSERT INTO role_permission values(6,19);

SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='purchase_apartment_readonly' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='purchase_apartment_default' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='purchase_apartment_admin' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;

-- 仓库管理部门
INSERT INTO permission values(20,'instoreform_select','查看入库单');
INSERT INTO permission values(21,'instoreform_insert','新增入库单');
INSERT INTO permission values(22,'instoreform_update','修改入库单');
INSERT INTO permission values(23,'instoreform_delete','删除入库单');

INSERT INTO permission values(24,'outstoreform_select','查看出库单');
INSERT INTO permission values(25,'outstoreform_insert','新增出库单');
INSERT INTO permission values(26,'outstoreform_update','修改出库单');
INSERT INTO permission values(27,'outstoreform_delete','删除出库单');

INSERT INTO role values(7,'store_keeper_readonly','库管部门只读角色');
INSERT INTO role values(8,'store_keeper_default','库管部门默认角色CRUD(修改删除只能对自己的表操作)');
INSERT INTO role values(9,'store_keeper_admin','库管部门管理员角色(可修改删除其他人的表)');

INSERT INTO role_permission values(7,20);
INSERT INTO role_permission values(7,24);

INSERT INTO role_permission values(8,20);
INSERT INTO role_permission values(8,21);
INSERT INTO role_permission values(8,22);
INSERT INTO role_permission values(8,23);
INSERT INTO role_permission values(8,24);
INSERT INTO role_permission values(8,25);
INSERT INTO role_permission values(8,26);
INSERT INTO role_permission values(8,27);

INSERT INTO role_permission values(9,20);
INSERT INTO role_permission values(9,21);
INSERT INTO role_permission values(9,22);
INSERT INTO role_permission values(9,23);
INSERT INTO role_permission values(9,24);
INSERT INTO role_permission values(9,25);
INSERT INTO role_permission values(9,26);
INSERT INTO role_permission values(9,27);

SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='store_keeper_readonly' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='store_keeper_default' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='store_keeper_admin' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;

-- 最高管理员
INSERT INTO role values(10,'admin','最高权限');
INSERT INTO role_permission values(10,1);
INSERT INTO role_permission values(10,2);
INSERT INTO role_permission values(10,3);
INSERT INTO role_permission values(10,4);
INSERT INTO role_permission values(10,5);
INSERT INTO role_permission values(10,6);
INSERT INTO role_permission values(10,7);
INSERT INTO role_permission values(10,8);
INSERT INTO role_permission values(10,9);
INSERT INTO role_permission values(10,10);
INSERT INTO role_permission values(10,11);
INSERT INTO role_permission values(10,12);
INSERT INTO role_permission values(10,13);
INSERT INTO role_permission values(10,14);
INSERT INTO role_permission values(10,15);
INSERT INTO role_permission values(10,16);
INSERT INTO role_permission values(10,17);
INSERT INTO role_permission values(10,18);
INSERT INTO role_permission values(10,19);
INSERT INTO role_permission values(10,20);
INSERT INTO role_permission values(10,21);
INSERT INTO role_permission values(10,22);
INSERT INTO role_permission values(10,23);
INSERT INTO role_permission values(10,24);
INSERT INTO role_permission values(10,25);
INSERT INTO role_permission values(10,26);
INSERT INTO role_permission values(10,27);
SELECT role_name,permission_name,permission.description FROM permission,role,role_permission WHERE role.role_name='admin' AND role.role_id=role_permission.role_id AND permission.permission_id=role_permission.permission_id;

-- 测试数据
-- 测试用户
INSERT INTO employee VALUES(16001,'需求部门只读',1111,'xxxxx',100000,1);
INSERT INTO employee VALUES(16002,'需求部门默认',2222,'xxxxx',100000,1);
INSERT INTO employee VALUES(16003,'需求部门高级',3333,'xxxxx',100000,1);
INSERT INTO employee VALUES(16004,'采购部门只读',4444,'xxxxx',100000,1);
INSERT INTO employee VALUES(16005,'采购部门默认',5555,'xxxxx',100000,1);
INSERT INTO employee VALUES(16006,'采购部门高级',6666,'xxxxx',100000,1);
INSERT INTO employee VALUES(16007,'库管部门只读',7777,'xxxxx',100000,1);
INSERT INTO employee VALUES(16008,'库管部门默认',8888,'xxxxx',100000,1);
INSERT INTO employee VALUES(16009,'库管部门高级',9999,'xxxxx',100000,1);
INSERT INTO employee VALUES(16010,'系统管理员','admin','xxxxx',100000,1);

INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16001', '1');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16002', '2');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16003', '3');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16004', '4');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16005', '5');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16006', '6');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16007', '7');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16008', '8');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16009', '9');
INSERT INTO `purchase`.`employee_role` (`employee_id`, `role_id`) VALUES ('16010', '10');


