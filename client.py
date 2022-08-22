import socket as sk
socket = sk.socket()
socket.connect(("192.168.1.242",9999))
socket.send("msg".encode())
socket.close()