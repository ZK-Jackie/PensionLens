from flask import Flask, request
from calc_code import calculate
import json
from concurrent.futures import ThreadPoolExecutor
import config as cfg
from update_sql import update_state
import time
import logging

# 创建线程池，可以同时执行两个任务：测算+日志记录
# executor = ThreadPoolExecutor(2)
# 创建flask应用实例
app = Flask(__name__)


def log_func():
    """
    该函数用于创建和配置日志器对象，以便在执行养老保险测算任务时记录日志。

    Returns:
    logger: 配置完成的日志器对象。

    Note:
    该函数会检查日志器是否已经有处理器（handler），如果没有，则会添加一个控制台处理器。控制台处理器会将日志信息输出到控制台。
    """
    # 创建日志器对象
    logger = logging.getLogger(__name__)

    # 设置logger可输出日志级别范围
    logger.setLevel(logging.ERROR)
    console_handler = logging.StreamHandler()
    # 设置格式并赋予handler
    formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    console_handler.setFormatter(formatter)
    # 添加控制台handler，用于输出日志到控制台
    if not logger.handlers:
        # 添加日志文件handler，用于输出日志到文件中
        # file_handler = logging.FileHandler(filename='log.log', encoding='UTF-8')

        # 将handler添加到日志器中
        logger.addHandler(console_handler)
        # logger.addHandler(file_handler)

        # file_handler.setFormatter(formatter)
    return logger


@app.route('/ylbxcs', methods=['GET', 'POST'])
def run_jobs():
    """
    ylbxcs函数用于接收测算任务的请求，并将这个请求提交到线程池中执行。
    该函数需要的字典为：
    - 'id': 测算任务的唯一标识符。
    - 'branch': 执行测算任务的环境标识符，可以是'gstest'（公司测试）或其他值。
    - 'userId': 提交测算任务的用户的唯一标识符。
    """
    # executor.submit(ylbxcs, request.get_json())
    data=request.get_json()
    success=ylbxcs(data)
    # 执行某个函数（假设是 ylbxcs），并判断其是否成功
    try:
        if success:
            result = {'status': 200, 'succeed': 'true', 'msg': "操作成功"}  # 执行成功
        else:
            result = {'status': 500, 'succeed': 'false', 'msg': "操作失败"}  # 执行失败
    except Exception as e:
        result = {'status': 500, 'succeed': 'false', 'msg': f"执行过程中出现错误: {str(e)}"}  # 捕获异常，返回错误信息

    # 将相应信息返回至响应体中
    return json.dumps(result, ensure_ascii=False)


#测试连通性
@app.route('/')
def index():
  return "Hello, World!"


def ylbxcs(data):
    """
    该函数用于执行养老保险测算任务。它接收一个包含测算任务相关信息的字典作为参数，
    然后提交这个任务到线程池中执行。

    Parameters:
    data (dict): 包含测算任务相关信息的字典。字典中应包含以下键值对：
        - 'id': 测算任务的唯一标识符。
        - 'branch': 执行测算任务的环境标识符，可以是'gstest'（公司测试）或其他值。
        - 'userId': 提交测算任务的用户的唯一标识符。

    Returns:
    bool: 如果测算成功，返回True；如果测算失败，返回False。

    Raises:
    Exception: 如果在执行测算任务过程中出现错误，该函数会捕获并记录这个错误，
    然后更新数据库中的相关记录以反映这个错误。
    """
    try:
        # 延迟一段时间等待数据库中有数据
        time.sleep(cfg.t)
        # 执行测算为id的任务，id-测算任务的唯一标识符，branch-执行测算任务的环境标识符（'gstest'或'serve'）
        calculate(data['id'], data['branch'])
        print("测算成功")
        # 更新数据库中的记录，0-未测算，1-测算中，2-测算成功，3-测算失败
        # update_state(2, 0, data['id'], data['branch'], data['userId'])
        return True
    except Exception as e:
        try:
            print("测算失败")
            # 更新数据库中的记录，0-未测算，1-测算中，2-测算成功，3-测算失败
            # update_state(3, str(e), data['id'], data['branch'], data['userId'])
        except Exception:
            print("测算失败")
            # 获取log对象
            log = log_func()
            # 将异常信息记录到log中
            log.error("====================【开始测试】====================", exc_info=True)
        return False

# 启动
if __name__ == '__main__':
    app.run(host=cfg.host_server, port=cfg.port_server, debug=True)
