host = "http://localhost:3306/"

# 开发数据库配置信息
dev_user = "pension_lens"
dev_password = "PensionLens"
dev_port = 3306
dev_database = "calc"

# 测试数据库配置信息
cs_user = "pension_lens"
cs_password = "PensionLens"
cs_port = 3306
cs_database = "calc"

# 服务器配置信息
host_server = 'localhost'
port_server = 8080

# 请求接口新增方案历史
cs_url = 'http://192.168.13.61:10081/api/retirecalculate/ylyctxcs/updateParamsByHisId'
dev_url = 'http://192.168.13.61:32085/api/retirecalculate/ylyctxcs/updateParamsByHisId'

# 为等待前端数据写入数据库，设置测算休眠时间，单位为“秒”
t = 7

# 测算默认参数
max_life_span = 100
min_enroll_age = 16

o_distribute_ratio = 0.7

r_old_male = 60
r_old_female_worker = 50
r_old_female_cadre = 55
