/*	
	数据库名：tswallpape
	工具：MySQL Workbench6.3e
    作者：Forever
    版本：1.0
    日期：2016-11-2
*/

/*1.用户表*/
create table `tswallpape`.`tb_user`(
	u_no int(11) auto_increment not null,		/*用户ID*/
	u_name varchar(50) not null,				/*用户名*/
	u_pass varchar(20) not null,				/*密码*/
    u_sex varchar(5) not null,					/*性别*/
    u_age int,									/*年龄*/
	u_photo varchar(200),						/*头像*/
    u_autograph varchar(500),					/*个性签名*/
	u_phone varchar(13),						/*手机号码*/
	u_email varchar(30),						/*电子邮箱*/
    u_intime datetime default current_timestamp,/*注册时间*/
    u_attention int default 0,					/*关注数量*/
	u_fans int default 0,						/*粉丝数量*/
    u_upload int default 0,						/*用户上传图片数量*/
    u_collect int default 0,					/*用户收藏图片数量*/
    u_state int default 0,						/*状态 0：正常，1：冻结*/
	u_obligate1 varchar(20),					/*预留字段*/
	u_obligate2 varchar(20),					/*预留字段*/
	u_obligate3 varchar(20),					/*预留字段*/
    primary key(u_no)
);
insert into tswallpape.tb_user values(0,'taylor','123','女',27,'picture/headPortrait/user/wallhaven-243076.jpg','enchanted','13035731854','1462455023@qq.com',default,default,default,default,default,default,null,null,null);
insert into tswallpape.tb_user values(0,'karlie','123','女',24,'picture/headPortrait/user/wallhaven-430284.jpg','playgame','13022226666','146@qq.com',default,default,default,default,default,default,null,null,null);

select * from tswallpape.tb_user;
/* -------------------------------------------------------------------------------------------------------- */
/*2.图片类型表*/
create table `tswallpape`.`tb_picture_type`
(
	`pt_id` int(11) auto_increment not null,
    `pt_name` varchar(20),
    primary key(pt_id)
);
insert into `tswallpape`.`tb_picture_type` values(0,'女神');
insert into `tswallpape`.`tb_picture_type` values(0,'美女');
insert into `tswallpape`.`tb_picture_type` values(0,'男人');
insert into `tswallpape`.`tb_picture_type` values(0,'动漫');
insert into `tswallpape`.`tb_picture_type` values(0,'风景');
insert into `tswallpape`.`tb_picture_type` values(0,'游戏');
insert into `tswallpape`.`tb_picture_type` values(0,'文字');
insert into `tswallpape`.`tb_picture_type` values(0,'视觉');
insert into `tswallpape`.`tb_picture_type` values(0,'情感');
insert into `tswallpape`.`tb_picture_type` values(0,'设计');
insert into `tswallpape`.`tb_picture_type` values(0,'明星');
insert into `tswallpape`.`tb_picture_type` values(0,'物语');
insert into `tswallpape`.`tb_picture_type` values(0,'卡通');
insert into `tswallpape`.`tb_picture_type` values(0,'机械');
insert into `tswallpape`.`tb_picture_type` values(0,'城市');
insert into `tswallpape`.`tb_picture_type` values(0,'动物');
insert into `tswallpape`.`tb_picture_type` values(0,'运动');
insert into `tswallpape`.`tb_picture_type` values(0,'视觉');
insert into `tswallpape`.`tb_picture_type` values(0,'其他');

select * from `tswallpape`.`tb_picture_type`;


/*3.图片表*/
create table `tswallpape`.`tb_picture`(
	p_no int(11) auto_increment not null,		/*图片ID*/
	p_name varchar(50) not null,				/*图片原名称*/
    p_path varchar(500) not null,				/*路径+自动生成名+后缀*/
	p_type int(11),								/*图片类型ID */
	p_date datetime default current_timestamp,	/*上传日期*/
	p_praise int default 0,						/*被赞数量*/
	P_describe varchar(500),					/*图片描述（用于搜索的关键词）*/							
	p_obligate1 varchar(20),					/*预留字段*/
	p_obligate2 varchar(20),					/*预留字段*/
    primary key(p_no)
);
insert into tswallpape.tb_picture values(0,'TS.jsp','图片路径+文件名+后缀',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'taylor.jsp','图片路径+文件名+后缀',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'karlie.jsp','图片路径+文件名+后缀',1,default,default,'karlie kloos，美女，女神,运动，欧美',null,null);
insert into tswallpape.tb_picture values(0,'karlie.jsp','图片路径+文件名+后缀',2,default,default,'kk，美女，女神,运动，欧美',null,null);

insert into tswallpape.tb_picture values(0,'taylor.jsp','picture/HD/wallhaven-244618.jpg',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'taylor.jsp','picture/HD/wallhaven-248459.jpg',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'taylor.jsp','picture/HD/wallhaven-264541.jpg',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'taylor.jsp','picture/HD/wallhaven-264543.jpg',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'taylor.jsp','picture/HD/wallhaven-273165.png',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);
insert into tswallpape.tb_picture values(0,'taylor.jsp','picture/HD/wallhaven-330161.jpg',1,default,default,'taylor swift,泰勒斯威夫特，霉霉，美女，女神，欧美',null,null);





select * from tswallpape.tb_picture;
select p.*,t.pt_name from tswallpape.tb_picture p left join tswallpape.tb_picture_type t on p.p_type=t.pt_id;

/*4.用户图片中间表*/
create table `tswallpape`.`tb_picture_user`(
	pu_no int(11) auto_increment not null,		/*用户图片中间表*/
	pu_uno int(11),								/*用户ID*/
	pu_pno int(11),								/*图片ID*/
    primary key(pu_no)
);
insert into tswallpape.tb_picture_user values(0,1,1);
insert into tswallpape.tb_picture_user values(0,1,2);
insert into tswallpape.tb_picture_user values(0,2,3);
insert into tswallpape.tb_picture_user values(0,2,4);

insert into tswallpape.tb_picture_user values(0,1,5);
insert into tswallpape.tb_picture_user values(0,1,6);
insert into tswallpape.tb_picture_user values(0,1,7);
insert into tswallpape.tb_picture_user values(0,1,8);
insert into tswallpape.tb_picture_user values(0,1,9);
insert into tswallpape.tb_picture_user values(0,1,10);

select * from tswallpape.tb_picture_user;

/* 查看用户上传的图片 */
select u.u_name 用户名,p.p_name 图片名 from tswallpape.tb_user u left join tswallpape.tb_picture_user pu 
on u.u_no=pu.pu_uno left join tswallpape.tb_picture p on pu.pu_pno=p.p_no;
/* ------------------------------------------------------------------------------------------- */

/*5.收藏图片表*/
create table `tswallpape`.`tb_collect`(
	c_no int(11) not null auto_increment,	/*收藏图片表ID*/
	c_uno int(11),							/*用户ID*/
	c_pno int(11),							/*图片ID*/
    primary key(c_no)
);
insert into tswallpape.tb_collect values(0,1,1);
insert into tswallpape.tb_collect values(0,1,2);
insert into tswallpape.tb_collect values(0,2,1);

update `tswallpape`.`tb_user` set `u_upload`='2' where `u_no`='1';
update `tswallpape`.`tb_user` set `u_upload`='1' where `u_no`='2';

update `tswallpape`.`tb_user` set `u_collect`='2' where `u_no`='1';
update `tswallpape`.`tb_user` set `u_collect`='1' where `u_no`='2';


select * from tswallpape.tb_collect;


/* .查询所有图片被哪些用户收藏 */
select p.p_no 图片ID,p.p_name 图片名称,u.u_name 收藏用户 from tswallpape.tb_picture p left join tswallpape.tb_collect c 
on p.p_no=c.c_pno left join tswallpape.tb_user u on c.c_uno = u.u_no;


/* 6.粉丝表 */
create table `tswallpape`.`tb_fans`(
	f_no int(11) auto_increment not null,		/*粉丝表ID*/
	f_uno int(11),								/*被关注用户ID*/
	f_uno2 int(11),								/*关注用户ID*/
    primary key(f_no)
);

/* ID为1的用户被ID为2的用户关注*/
insert into tswallpape.tb_fans values(0,1,2);
update `tswallpape`.`tb_user` set `u_fans`='1' where `u_no`='1';
update `tswallpape`.`tb_user` set `u_attention`='1' where `u_no`='2';

select * from tswallpape.tb_fans;

/*查看用户的粉丝数量及关注数量*/
select u.u_name 用户名,u.u_attention 关注数量,u.u_fans 粉丝数量 from 
tswallpape.tb_user u left join tswallpape.tb_fans f on u.u_no=f.f_uno;

/*查看ID为1的用户有哪些粉丝？*/
select u.u_name 用户名,u.u_fans 粉丝数量,u2.u_name 粉丝 from tswallpape.tb_user u left join tswallpape.tb_fans f on
 u.u_no=f.f_uno left join tswallpape.tb_user u2 on f.f_uno2=u2.u_no where u.u_no=1;

/*查看ID为2的用户关注了哪些用户？*/
select u.u_name 用户名,u.u_attention 关注数量,u2.u_name 我关注的用户 from tswallpape.tb_user u left join tswallpape.tb_fans f on
 u.u_no=f.f_uno2 left join tswallpape.tb_user u2 on f.f_uno=u2.u_no where u.u_no=2;


/* 7.图片评论表 */
create table `tswallpape`.`tb_comment`(
	co_no int(11) auto_increment not null,			/*图片评论表ID*/
	co_p_no int(11),								/*图片ID*/
    co_u_no int(11),								/*用户ID*/
	co_content varchar(500),						/*评论内容*/
	co_time	datetime default current_timestamp,		/*评论日期*/
	co_count int default 0,							/*评论被赞数量*/
	co_obligate varchar(20),						/*预留字段*/
    primary key(co_no)
);
insert into tswallpape.tb_comment values(0,1,1,'biutiful',default,default,null);
insert into tswallpape.tb_comment values(0,1,2,'taylor',default,default,null);
select * from tswallpape.tb_comment;

/*查看所有图片图片的评论内容、评论日期、评论时间、评论被赞数量及评论人*/
select p.p_name 图片名,co.co_content 评论内容,co.co_time 评论日期,co.co_count 评论被赞数,u.u_name 评论人 from tswallpape.tb_picture p left join tswallpape.tb_comment co on p.p_no=co.co_p_no left join tswallpape.tb_user u on co.co_u_no=u.u_no;

/* 8.赞评论表 */
create table `tswallpape`.`tb_praise_comment`(
	pc_no int(11) auto_increment not null,		/*赞评论表ID*/
    pc_co_no int(11),							/*图片评论ID*/
    pc_u_no int(11),							/*赞评论用户的ID*/
    primary key(pc_no)
);

/*为评论ID1的评论点赞(可以为自已的评论点赞)*/
	/*ID为1的用户点赞ID为1的评论*/
	insert into tswallpape.tb_praise_comment values(0,1,1);
	update `tswallpape`.`tb_comment` set `co_count`=1 where `co_no`='1';	/*点赞后此评论的赞+1*/
	
    /*ID为2的用户点赞ID为1的评论*/
	insert into tswallpape.tb_praise_comment values(0,1,2);
	update `tswallpape`.`tb_comment` set `co_count`=2 where `co_no`='1'; /*点赞后此评论的赞+1*/

select * from tswallpape.tb_praise_comment;

/*查看评论内容和赞数量*/
select co_no 评论ID,co_content 评论内容,co_count 评论数量 from `tswallpape`.`tb_comment`;

/* ------------------------------------------------------------------------------------------- */
/* 9管理员 */
create table `tswallpape`.`tb_admin`
(
	`a_id` int(11) auto_increment not null,
    `a_name` varchar(20) unique not null,
    `a_password` varchar(20) not null,
    primary key(a_id)
);
insert into `tswallpape`.`tb_admin` values(0,'admin2','123456');

insert into `tswallpape`.`tb_admin` values(0,'admin','123456');
select * from `tswallpape`.`tb_admin`;

/* ------------------------------------------------------------------------------------------- */
select * from (select * from `tswallpape`.`tb_picture` p left join `tswallpape`.`tb_picture_user` pr on p.p_no=pr.pu_pno left join `tswallpape`.`tb_picture_type` pt on p.p_type=pt.pt_id order by p.p_date desc,p.p_no desc) temporary_table limit 0,24;


