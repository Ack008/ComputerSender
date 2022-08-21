import socket
server_socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
port = 9999
socket_address = ("",port)
server_socket.bind(socket_address)
server_socket.listen(5)
while True:
    client_socket,addr = server_socket.accept()
    msg = client_socket.recv(4098).decode()
    print(msg)
#msg = client_socket.recv(4098).decode()
#print(msg)

server_socket.close()   