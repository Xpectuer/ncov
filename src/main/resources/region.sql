create schema ncov collate utf8mb4_0900_ai_ci;

create table dept
(
    dname varchar(100) null,
    loc varchar(50) null,
    deptno int auto_increment
        primary key
);

create table region
(
    provinceName varchar(255) null,
    confirmedCount int null,
    id int not null
        primary key,
    currentConfirmedCount int null,
    curedCount int null,
    deadCount int null,
    statisticsData varchar(255) null
);
INSERT INTO `region` (`id`, `provinceName`, `confirmedCount`, `currentConfirmedCount`, `curedCount`, `deadCount`, `statisticsData`) VALUES
(1, '台湾', 440, 35, 398, 7, 'https://file1.dxycdn.com/2020/0223/045/3398299749526003760-135.json'),
(2, '香港', 1055, 26, 1025, 4, 'https://file1.dxycdn.com/2020/0223/331/3398299755968040033-135.json'),
(3, '吉林省', 146, 22, 122, 2, 'https://file1.dxycdn.com/2020/0223/046/3398299755968039975-135.json'),
(4, '上海市', 666, 18, 641, 7, 'https://file1.dxycdn.com/2020/0223/128/3398299755968454977-135.json'),
(5, '内蒙古自治区', 213, 16, 196, 1, 'https://file1.dxycdn.com/2020/0223/783/3398299758115938727-135.json'),
(6, '湖北省', 68134, 6, 63616, 4512, 'https://file1.dxycdn.com/2020/0223/618/3398299751673487511-135.json'),
(7, '北京市', 593, 6, 578, 9, 'https://file1.dxycdn.com/2020/0223/004/3398299758115524169-135.json'),
(8, '陕西省', 308, 4, 301, 3, 'https://file1.dxycdn.com/2020/0223/857/3398299753820971228-135.json'),
(9, '广东省', 1590, 3, 1579, 8, 'https://file1.dxycdn.com/2020/0223/281/3398299758115524068-135.json'),
(10, '辽宁省', 149, 3, 144, 2, 'https://file1.dxycdn.com/2020/0223/815/3398299758115938736-135.json'),
(11, '天津市', 192, 2, 187, 3, 'https://file1.dxycdn.com/2020/0223/669/3398299753820555949-135.json'),
(12, '山东省', 788, 1, 780, 7, 'https://file1.dxycdn.com/2020/0223/601/3398299749526003726-135.json'),
(13, '海南省', 169, 1, 162, 6, 'https://file1.dxycdn.com/2020/0223/126/3398299753820555862-135.json'),
(14, '澳门', 45, 1, 44, 0, 'https://file1.dxycdn.com/2020/0223/840/3398299753820971267-135.json'),
(15, '河南省', 1276, 0, 1254, 22, 'https://file1.dxycdn.com/2020/0223/958/3398299751673487456-135.json'),
(16, '浙江省', 1268, 0, 1267, 1, 'https://file1.dxycdn.com/2020/0223/537/3398299755968455045-135.json'),
(17, '湖南省', 1019, 0, 1015, 4, 'https://file1.dxycdn.com/2020/0223/440/3398299751673072079-135.json'),
(18, '安徽省', 991, 0, 985, 6, 'https://file1.dxycdn.com/2020/0223/734/3398299753820971301-135.json'),
(19, '黑龙江省', 945, 0, 932, 13, 'https://file1.dxycdn.com/2020/0223/643/3398299753820971199-135.json'),
(20, '江西省', 937, 0, 936, 1, 'https://file1.dxycdn.com/2020/0223/161/3398299751673072165-135.json'),
(21, '江苏省', 653, 0, 653, 0, 'https://file1.dxycdn.com/2020/0223/111/3398299753820971290-135.json'),
(22, '重庆市', 579, 0, 573, 6, 'https://file1.dxycdn.com/2020/0223/368/3398299751673487486-135.json'),
(23, '四川省', 561, 0, 558, 3, 'https://file1.dxycdn.com/2020/0223/926/3398299755968455035-135.json'),
(24, '福建省', 356, 0, 355, 1, 'https://file1.dxycdn.com/2020/0223/744/3398299751673071813-135.json'),
(25, '河北省', 328, 0, 322, 6, 'https://file1.dxycdn.com/2020/0223/473/3398299751673487477-135.json'),
(26, '广西壮族自治区', 254, 0, 252, 2, 'https://file1.dxycdn.com/2020/0223/536/3398299758115523880-135.json'),
(27, '山西省', 198, 0, 198, 0, 'https://file1.dxycdn.com/2020/0223/196/3398299755968040081-135.json'),
(28, '云南省', 185, 0, 183, 2, 'https://file1.dxycdn.com/2020/0223/159/3398299758115523929-135.json'),
(29, '贵州省', 147, 0, 145, 2, 'https://file1.dxycdn.com/2020/0223/148/3398299753820971243-135.json'),
(30, '甘肃省', 139, 0, 137, 2, 'https://file1.dxycdn.com/2020/0223/559/3398299755968040166-135.json'),
(31, '新疆维吾尔自治区', 76, 0, 73, 3, 'https://file1.dxycdn.com/2020/0223/497/3398299753820556085-135.json'),
(32, '宁夏回族自治区', 75, 0, 75, 0, 'https://file1.dxycdn.com/2020/0223/353/3398299755968455019-135.json'),
(33, '青海省', 18, 0, 18, 0, 'https://file1.dxycdn.com/2020/0223/581/3398299758115524121-135.json'),
(34, '西藏自治区', 1, 0, 1, 0, 'https://file1.dxycdn.com/2020/0223/353/3398299755968039885-135.json');
