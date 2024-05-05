host = "http://localhost:3306/intelligent_cal"

# 开发数据库配置信息
dev_user = "root"
dev_password = "041006"
dev_port = 3306
dev_database = "intelligence_cal"

# 测试数据库配置信息
cs_user = "root"
cs_password = "041006"
cs_port = 3306
cs_database = "intelligence_cal"

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
