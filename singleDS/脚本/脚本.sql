DROP TABLE IF EXISTS "public"."t1";
CREATE TABLE "public"."t1" (
                               "id" date,
                               "name" varchar(255) COLLATE "pg_catalog"."default",
                               "birth_date" date,
                               "address_info" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for workorder_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."workorder_info";
CREATE TABLE "public"."workorder_info" (
                                           "id" date,
                                           "name" varchar(255) COLLATE "pg_catalog"."default",
                                           "birth_date" date,
                                           "address_info" varchar(255) COLLATE "pg_catalog"."default"
)