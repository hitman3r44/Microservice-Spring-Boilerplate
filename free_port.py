import os
import signal
from subprocess import Popen, PIPE

def get_env_file_ports(env_file_path):
    port_contain_word = '_PORT='
    ports = []
    try:
        with open(env_file_path) as f:
            for line in f:
                if line.__contains__(port_contain_word):
                    line = line.replace('\n', '')
                    port = line.split(port_contain_word)[1]
                    ports.append(port)

            return ports    

    except FileNotFoundError:
        print("FileNotFoundError ")



def terminate_port(port):
    try:
        command = 'lsof -t -i:' + str(port)
        process = Popen(command, shell=True, stdout=PIPE, stderr = PIPE)
        stdout, stderr = process.communicate()
        if stdout != b'':
            pid = int(stdout.decode())
            os.kill(pid, signal.SIGTERM)
            return True
        return False
    except:
        print("Can not close this port :" +port)
        return None
    



""" Collect all port number from .env file """
ports = get_env_file_ports('.env')
terminated_ports = []

for port in ports : 
    terminated = terminate_port(port)
    if(terminated) : 
        terminated_ports.append(port)

print(terminated_ports, sep=", ", end=" ")
print("ports are terminated")
