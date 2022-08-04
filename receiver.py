import socket as sk
import os
import pyttsx3
import sys

ascoltanto = True
def ricevi(conn : sk.socket):
    while ascoltanto:
        recv = conn.recv(4096).decode()
        if recv == "shut":
            ascoltanto = False
    os.system("shutdown /s /t 1")
    



id = sk.gethostbyname(sk.gethostname())
port = 9999
riuscita = True
try:
    socket = sk.socket()
    socket.bind(("",port))
    socket.listen(1)
except sk.error as er:
    print(f"Qualcosa è andato storto... {er}")
    riuscita = False

if riuscita:
    conn, add = socket.accept()
    ricevi(conn)
    
