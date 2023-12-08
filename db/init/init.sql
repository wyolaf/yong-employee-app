create database employee charset utf8mb4_0900_ai_ci;
use employee;
create table if not exists employee
(
    id              int auto_increment comment '职工名称'
    primary key,
    emp_name        varchar(20) null comment '职员姓名',
    sex             varchar(4)  null comment '性别 可选范围[男，女]',
    age             int         null comment '年龄',
    dept_name       varchar(10) null comment '部门名称 可选范围[业务部，后勤部，人事部]',
    emp_degree_name varchar(10) null comment '学历 可选范围[大专，本科，研究生]'
    );

create table if not exists sys_permission
(
    id       int          not null
    primary key,
    permName varchar(50)  null,
    permTag  varchar(50)  null,
    url      varchar(255) null comment '请求url'
    )
    charset = utf8;

create table if not exists sys_role
(
    id       int         not null
    primary key,
    roleName varchar(50) null,
    roleDesc varchar(50) null
    )
    charset = utf8;

create table if not exists sys_role_permission
(
    role_id int null,
    perm_id int null,
    constraint FK_Reference_3
    foreign key (role_id) references sys_role (id),
    constraint FK_Reference_4
    foreign key (perm_id) references sys_permission (id)
    )
    charset = utf8;

create table if not exists sys_user
(
    id                    int          not null
    primary key,
    username              varchar(50)  null,
    realname              varchar(50)  null,
    password              varchar(300) null,
    createDate            date         null,
    lastLoginTime         date         null,
    enabled               int          null,
    accountNonExpired     int          null,
    accountNonLocked      int          null,
    credentialsNonExpired int          null
    )
    charset = utf8;

create table if not exists sys_user_role
(
    user_id int null,
    role_id int null,
    constraint FK_Reference_1
    foreign key (user_id) references sys_user (id),
    constraint FK_Reference_2
    foreign key (role_id) references sys_role (id)
    )
    charset = utf8;



INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (1, '张一', '男', 25, '业务部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (2, '张二', '女', 26, '人事部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (3, '张三', '男', 27, '后勤部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (4, '张四', '女', 28, '人事部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (5, '张五', '男', 29, '后勤部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (6, '张六', '女', 29, '后勤部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (7, '张七', '男', 33, '业务部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (8, '张八', '男', 32, '业务部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (9, '张九', '女', 33, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (10, '李一', '女', 45, '业务部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (11, '李二', '女', 19, '人事部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (12, '李三', '男', 28, '业务部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (13, '李四', '女', 46, '后勤部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (14, '李五', '男', 58, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (15, '李六', '女', 22, '人事部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (16, '李七', '男', 26, '后勤部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (17, '李八', '男', 25, '人事部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (18, '李九', '女', 29, '后勤部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (19, '王一', '男', 45, '后勤部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (20, '王二', '女', 21, '业务部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (21, '王三', '男', 21, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (22, '王四', '男', 23, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (23, '王五', '女', 33, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (24, '王六', '男', 45, '人事部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (25, '王七', '男', 35, '业务部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (26, '王八', '男', 41, '后勤部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (27, '王九', '女', 25, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (28, '赵一', '男', 26, '人事部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (29, '赵二', '男', 20, '后勤部', '本科');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (30, '赵三', '女', 21, '人事部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (31, '赵四', '男', 19, '后勤部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (32, '赵五', '女', 35, '后勤部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (33, '赵六', '男', 24, '业务部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (34, '赵七', '男', 29, '业务部', '大专');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (35, '赵八', '女', 33, '业务部', '研究生');
INSERT INTO employee.employee (id, emp_name, sex, age, dept_name, emp_degree_name) VALUES (36, '赵九', '男', 45, '业务部', '本科');



INSERT INTO employee.sys_permission (id, permName, permTag, url) VALUES (1, '查询用户', 'getUser', '/getUser');
INSERT INTO employee.sys_permission (id, permName, permTag, url) VALUES (2, '添加用户', 'addUser', '/addUser');
INSERT INTO employee.sys_permission (id, permName, permTag, url) VALUES (3, '修改用户', 'updateUser', '/updateUser');
INSERT INTO employee.sys_permission (id, permName, permTag, url) VALUES (4, '删除用户', 'delUser', '/delUser');


INSERT INTO employee.sys_role (id, roleName, roleDesc) VALUES (1, 'admin', '管理员');
INSERT INTO employee.sys_role (id, roleName, roleDesc) VALUES (2, 'add_user', '添加管理员');


INSERT INTO employee.sys_role_permission (role_id, perm_id) VALUES (1, 1);
INSERT INTO employee.sys_role_permission (role_id, perm_id) VALUES (1, 2);
INSERT INTO employee.sys_role_permission (role_id, perm_id) VALUES (1, 3);
INSERT INTO employee.sys_role_permission (role_id, perm_id) VALUES (1, 4);
INSERT INTO employee.sys_role_permission (role_id, perm_id) VALUES (2, 2);


INSERT INTO employee.sys_user (id, username, realname, password, createDate, lastLoginTime, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (1, 'mayikt_admin', '张三', '99743025dc21f56c63d0cb2dd34f06f5', '2018-11-13', '2018-11-13', 1, 1, 1, 1);
INSERT INTO employee.sys_user (id, username, realname, password, createDate, lastLoginTime, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (2, 'mayikt_add', '小余', 'a5a6996f2e1953161522a93cbb5fb556', '2018-11-13', '2018-11-13', 1, 1, 1, 1);
INSERT INTO employee.sys_user (id, username, realname, password, createDate, lastLoginTime, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (3, 'admin', '管理员', '$2a$10$D//3zO957rRfbUim4oAL8.YH1Ji39pvzyBEH7SwjhBc8X7gl6fTvm', '2018-11-13', '2018-11-13', 1, 1, 1, 1);


INSERT INTO employee.sys_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO employee.sys_user_role (user_id, role_id) VALUES (2, 2);
