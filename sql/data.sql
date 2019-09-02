CREATE DATABASE /*!32312 IF NOT EXISTS*/`sp-assets` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sp-assets`;
set names utf8;
-- ----------------------------
-- Records of asset_group
-- ----------------------------

INSERT INTO `asset_group` VALUES ('531ad030-ed10-4083-bd0f-2c0f4dcb2444', '0', '0', '资产组', 3, 333, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444', NULL, NULL, NULL, '2019-08-26 13:56:52', NULL, 'test');
INSERT INTO `asset_group` VALUES ('6bd90184-8aaf-4907-a57f-8306a77d80df', '0', '8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2', '等保资产组B', 2, 122, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2/6bd90184-8aaf-4907-a57f-8306a77d80df', NULL, NULL, NULL, '2019-08-27 11:56:51', NULL, 'test');
INSERT INTO `asset_group` VALUES ('8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2', '0', '531ad030-ed10-4083-bd0f-2c0f4dcb2444', '等保资产组', 2, 122, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2', NULL, NULL, NULL, '2019-08-27 11:56:14', NULL, 'test');
INSERT INTO `asset_group` VALUES ('a1587001-b192-415c-8657-c06620c49e02', '0', '0', '漏洞组', 3, 233, '/a1587001-b192-415c-8657-c06620c49e02', NULL, NULL, NULL, '2019-08-26 13:58:20', NULL, 'test');
INSERT INTO `asset_group` VALUES ('c1ff5d47-34fc-4da5-94da-3a52317e0582', '0', '8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2', '等保资产组A', 2, 111, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2/c1ff5d47-34fc-4da5-94da-3a52317e0582', NULL, NULL, NULL, '2019-08-27 11:56:31', NULL, 'test');
INSERT INTO `asset_group` VALUES ('d6283e94-3230-4f6f-b3ef-e464c0eb8b0c', '0', '0', '告警组', 4, 233, '/d6283e94-3230-4f6f-b3ef-e464c0eb8b0c', NULL, NULL, NULL, '2019-08-26 13:59:56', NULL, 'test');
INSERT INTO `asset_group` VALUES ('e8e34f09-f638-4690-b69a-ff593ee281de', '0', '531ad030-ed10-4083-bd0f-2c0f4dcb2444', '涉密资产', 3, 233, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/e8e34f09-f638-4690-b69a-ff593ee281de', NULL, NULL, NULL, '2019-08-26 14:01:49', NULL, 'test');


-- ----------------------------
-- Records of asset_object
-- ----------------------------
INSERT INTO `asset_object` VALUES ('a5194e63-119a-40b4-9235-79f029532e76', 'a7f08b59-6c8f-476e-a9f2-7946eaa03458', '/Isolation/info', NULL, NULL, NULL, NULL, '等保资产3', '192.168.7.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, '2019-08-27 15:28:57', NULL, 4, 4, 3, 4, 333, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2/c1ff5d47-34fc-4da5-94da-3a52317e0582/a5194e63-119a-40b4-9235-79f029532e76', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `asset_object` VALUES ('bed4ad29-18e3-483a-8d2f-3b8dea2a20f2', '9410cb20-d633-4bba-b959-b19f8541cbbe', '/Isolation/Extranet', NULL, NULL, NULL, NULL, '等保资产2', '192.168.7.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, 1, NULL, '2019-08-27 15:28:24', NULL, 4, 3, 3, 4, 233, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2/c1ff5d47-34fc-4da5-94da-3a52317e0582/bed4ad29-18e3-483a-8d2f-3b8dea2a20f2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `asset_object` VALUES ('f2b440a0-b372-4219-9792-85ecf37c7d39', '10e3ec91-3ad0-4ae7-8b6d-ed9bf2a9ee3d', '/Isolation/Intranet', NULL, NULL, NULL, NULL, '等保资产1', '192.168.7.1', NULL, NULL, NULL, NULL, NULL, 'venus', NULL, NULL, '1', NULL, NULL, NULL, 1, NULL, '2019-08-27 15:27:02', NULL, 1, 4, 3, 1, 333, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2/c1ff5d47-34fc-4da5-94da-3a52317e0582/f2b440a0-b372-4219-9792-85ecf37c7d39', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);



-- ----------------------------
-- Records of asset_object_pre
-- ----------------------------
INSERT INTO `asset_object_pre` VALUES ('a5194e63-119a-40b4-9235-79f029532e76', 'a7f08b59-6c8f-476e-a9f2-7946eaa03458', '/Isolation/info', NULL, NULL, NULL, NULL, '等保资产3', '192.168.7.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, '2019-08-27 15:28:57', NULL, 4, 4, 3, 4, 333, '/531ad030-ed10-4083-bd0f-2c0f4dcb2444/8ae8ab32-a0bc-4195-9fd0-ca59ba5111b2/c1ff5d47-34fc-4da5-94da-3a52317e0582/a5194e63-119a-40b4-9235-79f029532e76', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);


-- ----------------------------
-- Records of asset_tag
-- ----------------------------
INSERT INTO `asset_tag` VALUES ('074c95cd-1979-466c-90fb-0f7d148b9a82', 'ace709d8-1ec9-4c5a-a92c-6e8cb2a36992', '数据安全', '#ff8a65', NULL, '2019-08-27 10:28:12', NULL);
INSERT INTO `asset_tag` VALUES ('12a08fae-2ea2-497c-a8c7-be2869201429', '7e309b45-c2a3-49db-97f0-2d6c9db9b88f', '资质信息', '#b71c1c', NULL, '2019-08-27 10:26:45', NULL);
INSERT INTO `asset_tag` VALUES ('270ba72a-51ce-48dd-8f18-c7413c8a0cfd', 'ace709d8-1ec9-4c5a-a92c-6e8cb2a36992', '网络安全', '#90a4ae', NULL, '2019-08-27 10:54:39', NULL);
INSERT INTO `asset_tag` VALUES ('6037ae9f-7d4b-4311-8555-a9ea112e1b26', '7e309b45-c2a3-49db-97f0-2d6c9db9b88f', '商标信息', '#7986cb', NULL, '2019-08-27 10:27:13', NULL);
INSERT INTO `asset_tag` VALUES ('8d3d4fb5-19bb-4037-a149-bb83b1e14c57', 'ace709d8-1ec9-4c5a-a92c-6e8cb2a36992', '信息安全', '#ff6f00', NULL, '2019-08-27 10:27:50', NULL);

-- ----------------------------
-- Records of asset_tag_group
-- ----------------------------
INSERT INTO `asset_tag_group` VALUES ('7e309b45-c2a3-49db-97f0-2d6c9db9b88f', '0', 0, '资产信息', '/7e309b45-c2a3-49db-97f0-2d6c9db9b88f', NULL, NULL, NULL, NULL, '2019-08-27 10:26:45', NULL, '资产信息');
INSERT INTO `asset_tag_group` VALUES ('ace709d8-1ec9-4c5a-a92c-6e8cb2a36992', '0', 0, '资产安全', '/ace709d8-1ec9-4c5a-a92c-6e8cb2a36992', NULL, NULL, NULL, NULL, '2019-08-27 10:27:37', NULL, '资产安全');



-- ----------------------------
-- Records of asset_tag_object_rlt
-- ----------------------------
INSERT INTO `asset_tag_object_rlt` VALUES ('09097c34-2a3a-427b-8e65-44be2bea154f', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '93ef42f0-81a5-4dc3-afcf-0cd2eda7170e');
INSERT INTO `asset_tag_object_rlt` VALUES ('09815771-9ba0-401e-afb3-83495d1720e2', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '0fc9923c-a4cb-41a4-8264-566e9998a44f');
INSERT INTO `asset_tag_object_rlt` VALUES ('0c496741-205e-49a3-a573-1cc36666876f', '1066cb62-5af0-42a5-ab3c-f10504c5447b', '6d4b8576-9485-4663-9921-c42e05c17fba');
INSERT INTO `asset_tag_object_rlt` VALUES ('0e314055-b6bd-4611-9e7f-5db31f96bb34', '14f020d0-92fc-41f7-8d09-9b55ff78c65f', 'f2e5612c-2bad-49f6-af29-9a39d1d19299');
INSERT INTO `asset_tag_object_rlt` VALUES ('1222', '1dd02467-50d2-4c12-824d-231055a3d6ee', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('12222', '13166961-70c2-4e46-8f21-2a2d18ea043b', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('153a0a9d-3721-4228-aae1-543028826a94', '14f020d0-92fc-41f7-8d09-9b55ff78c65f', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('15cd56e0-0ca2-4fb5-9d7b-a41798c3ba6b', '51af302e-2083-4ba3-a164-e45c1fdc3321', '6ecdba7e-9ad0-4118-92db-ee5f816454c9');
INSERT INTO `asset_tag_object_rlt` VALUES ('1637c34f-ba7f-41de-9d9a-8942ce5f7a1f', '8d3d4fb5-19bb-4037-a149-bb83b1e14c57', '07d13511-c5ce-4a00-8215-4b000c184304');
INSERT INTO `asset_tag_object_rlt` VALUES ('17c17463-79f7-4366-a150-76ffa13a2583', '8d3d4fb5-19bb-4037-a149-bb83b1e14c57', '0ad673ca-97a3-4e9d-80fb-9273d9c925cf');
INSERT INTO `asset_tag_object_rlt` VALUES ('184a0d92-eaed-439a-8d71-1f98143e472f', '51af302e-2083-4ba3-a164-e45c1fdc3321', '7b01255b-84ef-4ad3-b252-f89820ad586f');
INSERT INTO `asset_tag_object_rlt` VALUES ('19165c1e-419c-495f-a339-86abeb1944f4', '1066cb62-5af0-42a5-ab3c-f10504c5447b', '1dd02467-50d2-4c12-824d-231055a3d6ee');
INSERT INTO `asset_tag_object_rlt` VALUES ('1bef7ee7-1592-45d8-bca8-9175e4d57141', '14f020d0-92fc-41f7-8d09-9b55ff78c65f', '388793e7-71c9-4a79-8366-756047aef687');
INSERT INTO `asset_tag_object_rlt` VALUES ('2222', '2a2ca814-508d-4403-9711-daf68398e664', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('2446a0e6-7679-4540-9dae-9941587e8e2b', '2a2ca814-508d-4403-9711-daf68398e664', 'a6666210-2451-4531-9168-9e42b8187c62');
INSERT INTO `asset_tag_object_rlt` VALUES ('2918676b-2d71-433c-bb23-5b16eb3459b1', '51af302e-2083-4ba3-a164-e45c1fdc3321', 'af7f124d-eae7-4e47-94f6-1f610a399f24');
INSERT INTO `asset_tag_object_rlt` VALUES ('29f9fa55-2682-41be-b6e2-26f362b8530b', '12a08fae-2ea2-497c-a8c7-be2869201429', 'eb1d9243-00a7-4fe9-bb61-8c172011d0fa');
INSERT INTO `asset_tag_object_rlt` VALUES ('2b884cd7-3c5f-4bf5-a8ae-ee720e325e9e', '103', '7ea8e204-583d-406f-a0d5-762c9169650d');
INSERT INTO `asset_tag_object_rlt` VALUES ('2cb55b7b-fa47-4070-8b75-797d1c2ae260', '36c02317-0182-4609-a43d-6fe08181a847', '251fba90-41d8-4242-8c11-241f459cc5a4');
INSERT INTO `asset_tag_object_rlt` VALUES ('2fc61c75-d186-4152-8385-e2acb38bc78b', '2f7118c6-e560-4f32-9669-0928707e5755', '8942ed2d-092f-4c06-9d85-3ef2551fbd93');
INSERT INTO `asset_tag_object_rlt` VALUES ('31b38f11-8d26-4568-957f-3379284d86fb', '8d3d4fb5-19bb-4037-a149-bb83b1e14c57', 'f2b440a0-b372-4219-9792-85ecf37c7d39');
INSERT INTO `asset_tag_object_rlt` VALUES ('31bbd5e2-31e1-4d02-af25-ad081eb56a98', '103', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('33333', '104', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('33f501bf-0780-4036-9789-2951f49fbdeb', '270ba72a-51ce-48dd-8f18-c7413c8a0cfd', 'e185bbf9-07e7-4a17-9403-e1cbdaee91da');
INSERT INTO `asset_tag_object_rlt` VALUES ('360e4f8b-40fa-4038-b102-c27d26a5d401', '2f7118c6-e560-4f32-9669-0928707e5755', '87cb18bd-0bc1-4a1c-b045-2023fe37f5f5');
INSERT INTO `asset_tag_object_rlt` VALUES ('379208e0-f4a0-4712-aa62-7cc62c383f6f', '12a08fae-2ea2-497c-a8c7-be2869201429', 'e741e88e-1522-4455-9c4a-7b8d29260564');
INSERT INTO `asset_tag_object_rlt` VALUES ('3aed38ed-c088-4f8b-a01f-46ad69846d61', 'd4c118f4-c735-4c57-9043-d792bbdade2c', '0fc9923c-a4cb-41a4-8264-566e9998a44f');
INSERT INTO `asset_tag_object_rlt` VALUES ('3e7e080f-024e-4485-9f46-b648e5b56d82', 'd4c118f4-c735-4c57-9043-d792bbdade2c', '3ab55749-15f3-4087-8ba2-19f81319e154');
INSERT INTO `asset_tag_object_rlt` VALUES ('3fb248c2-0a37-40c7-b6b9-3ddc77de45e5', '2a2ca814-508d-4403-9711-daf68398e664', '1c85f66d-f4e2-44ff-8035-35f336e45e22');
INSERT INTO `asset_tag_object_rlt` VALUES ('41909ea7-e5f8-417f-bf63-09120c1c0526', '3781e9de-dbd4-45bf-81d0-939a5841a72b', 'caaa7104-3b4f-482f-9df1-17aac6895191');
INSERT INTO `asset_tag_object_rlt` VALUES ('4ed83414-0745-4ae9-9b43-1eab19224c17', '标签1', 'c081fc79-aa36-4899-a0c4-c5dcbe262e54');
INSERT INTO `asset_tag_object_rlt` VALUES ('531935c5-dc25-4036-a5de-96eeea365976', 'eaf38b50-cca6-484e-9996-b080c3dfdd82', '1d4aa698-499f-480c-8e0c-4367d615cc07');
INSERT INTO `asset_tag_object_rlt` VALUES ('55008885-4b67-4e7d-bbe4-f105ee3d621f', '12a08fae-2ea2-497c-a8c7-be2869201429', 'f6992d6f-a5f1-4956-b035-c6da5049ccb5');
INSERT INTO `asset_tag_object_rlt` VALUES ('55da05d6-d136-41ad-9b3b-6cd0754e312c', '1066cb62-5af0-42a5-ab3c-f10504c5447b', 'de630975-a7f1-4b4e-b44d-283e525a06a2');
INSERT INTO `asset_tag_object_rlt` VALUES ('56d91596-dc6f-4234-b13b-ca22dc36790b', '48336f25-9b31-4888-92a4-4869c555c64b', '1dd02467-50d2-4c12-824d-231055a3d6ee');
INSERT INTO `asset_tag_object_rlt` VALUES ('59023a3b-1c77-4b9e-b480-8e8907e09cb5', '103', 'ccf19638-d9af-40c2-93ef-374ddc10ff06');
INSERT INTO `asset_tag_object_rlt` VALUES ('5af72a14-2d43-4dbe-a58e-0d4380c348de', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '3ab55749-15f3-4087-8ba2-19f81319e154');
INSERT INTO `asset_tag_object_rlt` VALUES ('5bc5fe89-f6f2-4dd2-b520-7605fbfa2372', '3781e9de-dbd4-45bf-81d0-939a5841a72b', '12287e5e-c384-477e-9db2-a869fc6d4cb6');
INSERT INTO `asset_tag_object_rlt` VALUES ('5edf1c81-ffba-470d-bd0c-31eb76402cc8', '103', '5f9c5e65-66d2-46b7-a366-b1f18ae651e4');
INSERT INTO `asset_tag_object_rlt` VALUES ('5fc9d76b-ab91-4694-9a3a-89e53b09a3ee', '1066cb62-5af0-42a5-ab3c-f10504c5447b', '82452b83-f0ac-4da3-b953-cca38b27e172');
INSERT INTO `asset_tag_object_rlt` VALUES ('621c9328-f19c-4f01-92aa-ba13cf943f9c', '6037ae9f-7d4b-4311-8555-a9ea112e1b26', '0ad673ca-97a3-4e9d-80fb-9273d9c925cf');
INSERT INTO `asset_tag_object_rlt` VALUES ('62655584-c82e-4909-8253-428122c73bad', '369a544e-8470-4686-b5a6-4306424986cc', '9f0c570f-1e1b-42a2-9188-a030bef9c098');
INSERT INTO `asset_tag_object_rlt` VALUES ('646b1a9a-dbae-4e7a-81f7-9d7efcddb14e', 'a1504f6b-8190-4f46-b5c8-64e19416b4d3', '3ab55749-15f3-4087-8ba2-19f81319e154');
INSERT INTO `asset_tag_object_rlt` VALUES ('661438fa-e3a7-4261-be45-eb13ae9a985c', 'a1504f6b-8190-4f46-b5c8-64e19416b4d3', '93ef42f0-81a5-4dc3-afcf-0cd2eda7170e');
INSERT INTO `asset_tag_object_rlt` VALUES ('686429c6-fcb4-453a-ac34-5593cbd0790e', '074c95cd-1979-466c-90fb-0f7d148b9a82', '9bdb3426-3573-4ed6-b1c5-11ef0ffb128c');
INSERT INTO `asset_tag_object_rlt` VALUES ('6a900f47-cbcd-49a2-9c98-d519426b4a47', 'e6776f65-afeb-4ad9-9c78-d149bbd5de6e', '8ca36ad2-0119-4e85-86f4-1825985d5526');
INSERT INTO `asset_tag_object_rlt` VALUES ('6c1de197-4096-463b-a35b-b3e0b74bda34', '6037ae9f-7d4b-4311-8555-a9ea112e1b26', 'f0200f53-1fa2-4876-988c-02a434552662');
INSERT INTO `asset_tag_object_rlt` VALUES ('749ccd5e-1169-4767-9d20-b6ce83254e89', '3fcb1a3a-0129-4f16-8984-becdd7b9253c', '1dd02467-50d2-4c12-824d-231055a3d6ee');
INSERT INTO `asset_tag_object_rlt` VALUES ('77054a04-01b7-4136-84fa-aaa3ae7c6575', '7aba6506-4ebd-4984-a6bb-c43fd834580b', '6d4b8576-9485-4663-9921-c42e05c17fba');
INSERT INTO `asset_tag_object_rlt` VALUES ('78be3932-7dd9-4612-af22-b84d6b68680d', 'c50014de-0698-440a-9c16-88029fb1247d', 'e7b177cb-d8af-4c4c-a52c-fadc5d9b0b03');
INSERT INTO `asset_tag_object_rlt` VALUES ('78e8d151-0534-4dae-b554-59421f0b6ecb', '36c02317-0182-4609-a43d-6fe08181a847', '33333');
INSERT INTO `asset_tag_object_rlt` VALUES ('808f628d-437a-48d3-86ce-74ab01cbc76e', '12a08fae-2ea2-497c-a8c7-be2869201429', '4b444354-2823-4774-a26f-bbc05f7a542f');
INSERT INTO `asset_tag_object_rlt` VALUES ('85db98f2-7439-43ee-a0af-873b4dc2d0a2', 'a1504f6b-8190-4f46-b5c8-64e19416b4d3', 'af7f124d-eae7-4e47-94f6-1f610a399f24');
INSERT INTO `asset_tag_object_rlt` VALUES ('8a8e35cf-ea4b-4c59-9285-957fc86bce5c', '103', 'e029319f-bbaa-437e-9d57-5cfa8863762e');
INSERT INTO `asset_tag_object_rlt` VALUES ('9094c1b9-8076-4123-b5bd-2a81c4004124', '270ba72a-51ce-48dd-8f18-c7413c8a0cfd', 'bed4ad29-18e3-483a-8d2f-3b8dea2a20f2');
INSERT INTO `asset_tag_object_rlt` VALUES ('90dedf84-a297-4583-975c-7354a8e40a2f', '0b860979-c216-44af-9cc1-2cbe9b0601e9', 'f2e5612c-2bad-49f6-af29-9a39d1d19299');
INSERT INTO `asset_tag_object_rlt` VALUES ('98f1478a-4027-4ea3-aa36-6c0887625aca', '6037ae9f-7d4b-4311-8555-a9ea112e1b26', '60891c3a-8e43-45a1-b46e-5f5dd03d36ef');
INSERT INTO `asset_tag_object_rlt` VALUES ('9adabee3-52a7-40e2-aea2-8c7d2f328ce7', '36c02317-0182-4609-a43d-6fe08181a847', '8ca36ad2-0119-4e85-86f4-1825985d5526');
INSERT INTO `asset_tag_object_rlt` VALUES ('9c51c953-1e94-46d1-b81d-f1d5de4b8bc2', '12a08fae-2ea2-497c-a8c7-be2869201429', '5e997d20-7c8c-439a-9af8-046f021d8f91');
INSERT INTO `asset_tag_object_rlt` VALUES ('9effa0f4-55e5-47e3-afa9-3d72cf8c495b', '103', 'aaa05a79-2036-4f14-b917-f27724308b91');
INSERT INTO `asset_tag_object_rlt` VALUES ('9fcb7f6d-bb8b-4b8e-adbc-3dbf66876ba5', '0b860979-c216-44af-9cc1-2cbe9b0601e9', 'caaa7104-3b4f-482f-9df1-17aac6895191');
INSERT INTO `asset_tag_object_rlt` VALUES ('a0ac735b-47dd-4756-967e-25a2c4226542', '103', 'b3003230-9419-4dbb-ba0b-0ff4d831faa1');
INSERT INTO `asset_tag_object_rlt` VALUES ('a25f8abb-18fc-4bad-b091-0458e3815f7d', '12a08fae-2ea2-497c-a8c7-be2869201429', 'f2b440a0-b372-4219-9792-85ecf37c7d39');
INSERT INTO `asset_tag_object_rlt` VALUES ('a46ed9a8-d23e-401b-8d92-4244bd7e7f8e', '3781e9de-dbd4-45bf-81d0-939a5841a72b', '0fc9923c-a4cb-41a4-8264-566e9998a44f');
INSERT INTO `asset_tag_object_rlt` VALUES ('a5075ee0-6a26-40c5-b6a2-c8a314e53eda', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '388793e7-71c9-4a79-8366-756047aef687');
INSERT INTO `asset_tag_object_rlt` VALUES ('a7518158-dcaf-4e0a-bbee-bf6b86137a51', '6037ae9f-7d4b-4311-8555-a9ea112e1b26', '7caaab0b-cde3-414f-ace2-e6d7b5efbf55');
INSERT INTO `asset_tag_object_rlt` VALUES ('a9a5af07-8dd1-4c5c-9e75-f9c31762ec5e', '14f020d0-92fc-41f7-8d09-9b55ff78c65f', '8ca36ad2-0119-4e85-86f4-1825985d5526');
INSERT INTO `asset_tag_object_rlt` VALUES ('ad2e9eed-0aa1-4b1a-9825-a7238d244209', '2f7118c6-e560-4f32-9669-0928707e5755', 'f2213154-1088-423a-9582-c1f93091e2f6');
INSERT INTO `asset_tag_object_rlt` VALUES ('aff42244-a500-4deb-ab92-1bef272ec2cb', '4c032388-91f1-460d-ba85-ae2ccbd61c9f', '8ca36ad2-0119-4e85-86f4-1825985d5526');
INSERT INTO `asset_tag_object_rlt` VALUES ('b0705726-dddf-474a-b8d2-41517942fb00', '369a544e-8470-4686-b5a6-4306424986cc', 'c3cc86c2-024f-4a2b-9745-df02f4c6023e');
INSERT INTO `asset_tag_object_rlt` VALUES ('b1941ed9-24b4-4c06-8b89-55db39a210c4', '369a544e-8470-4686-b5a6-4306424986cc', 'f6992d6f-a5f1-4956-b035-c6da5049ccb5');
INSERT INTO `asset_tag_object_rlt` VALUES ('b1a9aeb0-caf0-4341-a658-9e500424fbb3', '742a8f08-411a-48cd-aa4d-a1ae4c2e5ce4', '251fba90-41d8-4242-8c11-241f459cc5a4');
INSERT INTO `asset_tag_object_rlt` VALUES ('b261e9bc-947c-4851-95aa-af9998d04b1b', '51af302e-2083-4ba3-a164-e45c1fdc3321', '0fc9923c-a4cb-41a4-8264-566e9998a44f');
INSERT INTO `asset_tag_object_rlt` VALUES ('b4a3117c-a9c7-4016-ae3f-630bb73a3827', '3fcb1a3a-0129-4f16-8984-becdd7b9253c', '33333');
INSERT INTO `asset_tag_object_rlt` VALUES ('b6ae8bad-1793-4976-8197-b166f7e56d89', '51af302e-2083-4ba3-a164-e45c1fdc3321', '12287e5e-c384-477e-9db2-a869fc6d4cb6');
INSERT INTO `asset_tag_object_rlt` VALUES ('b6f7cddc-2ef3-4bd2-bf14-0c8d6430585d', '8d3d4fb5-19bb-4037-a149-bb83b1e14c57', '3804d042-04da-499e-8f68-17c05d31d256');
INSERT INTO `asset_tag_object_rlt` VALUES ('b80bce90-ddf6-45d1-a72a-b338fe9f9a30', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '7b01255b-84ef-4ad3-b252-f89820ad586f');
INSERT INTO `asset_tag_object_rlt` VALUES ('b9cd192e-47ea-4347-a5cf-b5c41d11db3f', '36c02317-0182-4609-a43d-6fe08181a847', '26758364-fc0e-4242-817c-0326f5d43be0');
INSERT INTO `asset_tag_object_rlt` VALUES ('baa78795-4d76-4296-9451-8db7610a703c', 'c50014de-0698-440a-9c16-88029fb1247d', '251fba90-41d8-4242-8c11-241f459cc5a4');
INSERT INTO `asset_tag_object_rlt` VALUES ('bcb36808-862b-4d14-b589-a575bda9e396', '369a544e-8470-4686-b5a6-4306424986cc', '5e997d20-7c8c-439a-9af8-046f021d8f91');
INSERT INTO `asset_tag_object_rlt` VALUES ('c4db2e87-0008-4f27-9f9d-41f075151875', '1066cb62-5af0-42a5-ab3c-f10504c5447b', '251fba90-41d8-4242-8c11-241f459cc5a4');
INSERT INTO `asset_tag_object_rlt` VALUES ('c7431130-1f06-4cc7-828f-482fc4bedec2', '3781e9de-dbd4-45bf-81d0-939a5841a72b', '7b01255b-84ef-4ad3-b252-f89820ad586f');
INSERT INTO `asset_tag_object_rlt` VALUES ('cb1a7bbc-c8cd-433d-a1d6-c6543a8e9c60', '7aba6506-4ebd-4984-a6bb-c43fd834580b', 'f2213154-1088-423a-9582-c1f93091e2f6');
INSERT INTO `asset_tag_object_rlt` VALUES ('cb4749b7-4264-455b-b743-2e3a82194be2', '12a08fae-2ea2-497c-a8c7-be2869201429', 'c3cc86c2-024f-4a2b-9745-df02f4c6023e');
INSERT INTO `asset_tag_object_rlt` VALUES ('ce1118e8-2e70-4c44-9bfb-8d88cb35f3f1', '3781e9de-dbd4-45bf-81d0-939a5841a72b', 'af7f124d-eae7-4e47-94f6-1f610a399f24');
INSERT INTO `asset_tag_object_rlt` VALUES ('ce8c90ad-4214-4c7a-bdf6-c73d75dfb0fd', '369a544e-8470-4686-b5a6-4306424986cc', '4b444354-2823-4774-a26f-bbc05f7a542f');
INSERT INTO `asset_tag_object_rlt` VALUES ('ceaf149f-3dbf-46a3-8cc4-7c0a5a775691', 'd4c118f4-c735-4c57-9043-d792bbdade2c', 'af7f124d-eae7-4e47-94f6-1f610a399f24');
INSERT INTO `asset_tag_object_rlt` VALUES ('cf5e8236-f3d4-4273-bd05-d6119b0ff6de', '3781e9de-dbd4-45bf-81d0-939a5841a72b', '3ab55749-15f3-4087-8ba2-19f81319e154');
INSERT INTO `asset_tag_object_rlt` VALUES ('d02f719f-80f8-4726-8a0b-38e389b1108e', 'a1504f6b-8190-4f46-b5c8-64e19416b4d3', '0fc9923c-a4cb-41a4-8264-566e9998a44f');
INSERT INTO `asset_tag_object_rlt` VALUES ('d09de630-8e52-44d2-ad41-42d29cab7063', '3781e9de-dbd4-45bf-81d0-939a5841a72b', '6ecdba7e-9ad0-4118-92db-ee5f816454c9');
INSERT INTO `asset_tag_object_rlt` VALUES ('d26c6ebe-75e3-4235-8e8a-d995dd61f26b', '369a544e-8470-4686-b5a6-4306424986cc', 'e741e88e-1522-4455-9c4a-7b8d29260564');
INSERT INTO `asset_tag_object_rlt` VALUES ('d41de51b-39fd-4dc8-9574-35476e37ea6a', '3fcb1a3a-0129-4f16-8984-becdd7b9253c', '26758364-fc0e-4242-817c-0326f5d43be0');
INSERT INTO `asset_tag_object_rlt` VALUES ('d51cfffa-dddf-498e-81a9-e8188420ee94', '7aba6506-4ebd-4984-a6bb-c43fd834580b', '6d951c87-fa27-4bcc-a95d-2271ddfda536');
INSERT INTO `asset_tag_object_rlt` VALUES ('d728d473-4e3b-4280-9dc0-6005dc79d090', '270ba72a-51ce-48dd-8f18-c7413c8a0cfd', '3804d042-04da-499e-8f68-17c05d31d256');
INSERT INTO `asset_tag_object_rlt` VALUES ('d8ca16fc-bf1b-44f0-ae15-99977238b851', '36c02317-0182-4609-a43d-6fe08181a847', '82452b83-f0ac-4da3-b953-cca38b27e172');
INSERT INTO `asset_tag_object_rlt` VALUES ('d9e60db7-f422-4c13-a428-40f6ae512b60', '103', 'da7501c9-f95b-4100-b9ee-1e1586f1d4c4');
INSERT INTO `asset_tag_object_rlt` VALUES ('dac9a817-f963-49cf-8570-31cb2980102a', '2a2ca814-508d-4403-9711-daf68398e664', '1dd02467-50d2-4c12-824d-231055a3d6ee');
INSERT INTO `asset_tag_object_rlt` VALUES ('deb95bba-6f54-4ea6-abbe-0e1edd154b5c', '3fcb1a3a-0129-4f16-8984-becdd7b9253c', '2f03c696-7c62-4dbe-85e4-8671e027088f');
INSERT INTO `asset_tag_object_rlt` VALUES ('df6dedc7-565a-43c8-bb94-7618d863a802', '0b860979-c216-44af-9cc1-2cbe9b0601e9', 'af7f124d-eae7-4e47-94f6-1f610a399f24');
INSERT INTO `asset_tag_object_rlt` VALUES ('dfc76d73-fc58-41cf-9858-d131a9dac7a1', 'a1504f6b-8190-4f46-b5c8-64e19416b4d3', '6ecdba7e-9ad0-4118-92db-ee5f816454c9');
INSERT INTO `asset_tag_object_rlt` VALUES ('e370ea4e-d5d9-4f2c-9821-f76da9c2917b', '6037ae9f-7d4b-4311-8555-a9ea112e1b26', '07d13511-c5ce-4a00-8215-4b000c184304');
INSERT INTO `asset_tag_object_rlt` VALUES ('e4ecd9f9-0b81-4687-9235-835b65b95f22', '36c02317-0182-4609-a43d-6fe08181a847', '1a0a875e-2fbb-4961-8d62-b345588ca03d');
INSERT INTO `asset_tag_object_rlt` VALUES ('e59ddc36-5d0e-4e09-a6c4-b32f6e72713f', '103', '35336465-e230-426a-ac6e-0b9e2d1f5a3f');
INSERT INTO `asset_tag_object_rlt` VALUES ('e757e7d0-9a45-4fa7-b833-57a9c86f3285', '2f7118c6-e560-4f32-9669-0928707e5755', '6d951c87-fa27-4bcc-a95d-2271ddfda536');
INSERT INTO `asset_tag_object_rlt` VALUES ('e7a985c9-feec-43d9-9566-3d722737cc92', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '12287e5e-c384-477e-9db2-a869fc6d4cb6');
INSERT INTO `asset_tag_object_rlt` VALUES ('e8024c8b-ad74-4bdd-bc8f-f0a762367913', '103', '5a1bbf53-4726-4d00-9223-63a1dc10241a');
INSERT INTO `asset_tag_object_rlt` VALUES ('e8930c0f-c83c-4b41-9677-41876645c428', 'd8731323-b321-481d-9e06-5a96d4d029dd', '2f03c696-7c62-4dbe-85e4-8671e027088f');
INSERT INTO `asset_tag_object_rlt` VALUES ('e8c381f6-97ab-4d19-b7fd-19f7d85c3dcb', '3781e9de-dbd4-45bf-81d0-939a5841a72b', '93ef42f0-81a5-4dc3-afcf-0cd2eda7170e');
INSERT INTO `asset_tag_object_rlt` VALUES ('e9cbdeb4-382c-4f23-b871-112d8a46c5c2', '8d3d4fb5-19bb-4037-a149-bb83b1e14c57', 'eb1d9243-00a7-4fe9-bb61-8c172011d0fa');
INSERT INTO `asset_tag_object_rlt` VALUES ('e9e991ec-3f2e-48de-b9b8-b8eaadba60c9', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '1a0a875e-2fbb-4961-8d62-b345588ca03d');
INSERT INTO `asset_tag_object_rlt` VALUES ('ea88195e-b5ac-4f0c-85b5-2dc9ba0050e1', '51af302e-2083-4ba3-a164-e45c1fdc3321', '3ab55749-15f3-4087-8ba2-19f81319e154');
INSERT INTO `asset_tag_object_rlt` VALUES ('edc0a53b-6adb-4868-875c-fdb85e7a0be9', 'd4c118f4-c735-4c57-9043-d792bbdade2c', '28572c9c-8b21-4aa5-bb05-aa0d0f8d35e2');
INSERT INTO `asset_tag_object_rlt` VALUES ('f4c35419-714e-4cd1-9230-1b134f8b8c3c', '2f7118c6-e560-4f32-9669-0928707e5755', '7f6dc7a5-40c5-4a6e-9d00-1fa9cf981ee8');
INSERT INTO `asset_tag_object_rlt` VALUES ('f79a4308-2685-40c5-814b-408ea3aa6035', '0b860979-c216-44af-9cc1-2cbe9b0601e9', '4b3babb4-024e-4868-a260-c9818a989db3');
INSERT INTO `asset_tag_object_rlt` VALUES ('faac1c57-43a8-4765-b3b0-1b7bf41ceb14', '1066cb62-5af0-42a5-ab3c-f10504c5447b', '8ca36ad2-0119-4e85-86f4-1825985d5526');
INSERT INTO `asset_tag_object_rlt` VALUES ('fb990ba1-db0e-4da1-9c36-fae95bebb35f', '12a08fae-2ea2-497c-a8c7-be2869201429', '9f0c570f-1e1b-42a2-9188-a030bef9c098');
INSERT INTO `asset_tag_object_rlt` VALUES ('fc1d9f53-e15c-4675-ab39-877fa604453c', '103', '60ef5eca-4567-4610-8d42-3e094a29d7ac');
INSERT INTO `asset_tag_object_rlt` VALUES ('ffbba7c4-90ea-4259-99ea-6a0571dc8233', '103', 'caaa7104-3b4f-482f-9df1-17aac6895191');

-- ----------------------------
-- Table structure for `asset_type`
-- ----------------------------

INSERT INTO `asset_type` VALUES ('0ea615a7-eca2-4753-bd39-0da92c8d686c', '0', 'edc2441c-f689-4e6a-9309-89af338d4ba2', '天虎隔离层', '/Isolation/TH', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/0ea615a7-eca2-4753-bd39-0da92c8d686c', 0, 0, 0, NULL, '2019-08-27 11:43:36', NULL, 'test');
INSERT INTO `asset_type` VALUES ('10e3ec91-3ad0-4ae7-8b6d-ed9bf2a9ee3d', '0', 'c030cbed-8723-4f7f-83ed-63bfbff88840', '内网安全层', '/Isolation/Intranet', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/633c4155-568f-4efe-9562-e0dc4fd72001/c030cbed-8723-4f7f-83ed-63bfbff88840/10e3ec91-3ad0-4ae7-8b6d-ed9bf2a9ee3d', 0, 0, 0, NULL, '2019-08-27 11:51:34', NULL, 'test');
INSERT INTO `asset_type` VALUES ('633c4155-568f-4efe-9562-e0dc4fd72001', NULL, 'edc2441c-f689-4e6a-9309-89af338d4ba2', '安全隔离层', '/Isolation/safe', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/633c4155-568f-4efe-9562-e0dc4fd72001', 0, 0, 0, NULL, NULL, NULL, 'test');
INSERT INTO `asset_type` VALUES ('9410cb20-d633-4bba-b959-b19f8541cbbe', '0', 'c030cbed-8723-4f7f-83ed-63bfbff88840', '外网安全', '/Isolation/Extranet', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/633c4155-568f-4efe-9562-e0dc4fd72001/c030cbed-8723-4f7f-83ed-63bfbff88840/9410cb20-d633-4bba-b959-b19f8541cbbe', 0, 0, 0, NULL, '2019-08-27 11:52:35', NULL, 'test');
INSERT INTO `asset_type` VALUES ('a5c3c786-9c92-45c5-9838-5e01cbd7ad15', '0', 'edc2441c-f689-4e6a-9309-89af338d4ba2', '安信隔离层', '/Isolation/AX', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/a5c3c786-9c92-45c5-9838-5e01cbd7ad15', 0, 0, 0, NULL, '2019-08-27 11:42:02', NULL, 'test');
INSERT INTO `asset_type` VALUES ('a7f08b59-6c8f-476e-a9f2-7946eaa03458', '0', '633c4155-568f-4efe-9562-e0dc4fd72001', '信息安全', '/Isolation/info', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/633c4155-568f-4efe-9562-e0dc4fd72001/a7f08b59-6c8f-476e-a9f2-7946eaa03458', 0, 0, 0, NULL, '2019-08-27 11:50:43', NULL, 'test');
INSERT INTO `asset_type` VALUES ('c030cbed-8723-4f7f-83ed-63bfbff88840', '0', '633c4155-568f-4efe-9562-e0dc4fd72001', '网络安全层', '/Isolation/NET', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2/633c4155-568f-4efe-9562-e0dc4fd72001/c030cbed-8723-4f7f-83ed-63bfbff88840', 0, 0, 0, NULL, '2019-08-27 11:49:55', NULL, 'test');
INSERT INTO `asset_type` VALUES ('edc2441c-f689-4e6a-9309-89af338d4ba2', '0', NULL, '隔离层', '/Isolation/', NULL, NULL, '/edc2441c-f689-4e6a-9309-89af338d4ba2', 0, 0, 0, NULL, '2019-08-27 11:41:35', NULL, 'test');

