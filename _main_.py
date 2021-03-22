import socket


def start_my_server():
    try:
        server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server_socket.bind(('127.0.0.1', 2000))
        server_socket.listen(100)
        print('Working....')
        while (True):
            client_socket, adress = server_socket.accept()
            data = client_socket.recv(1024).decode('utf-8')
            print(data)

            content = load_page_from_get_request(data)
            client_socket.send(content)
            client_socket.shutdown(socket.SHUT_WR)
    except KeyboardInterrupt:
        server_socket.close()
        print('shutting down list..')

def load_page_from_get_request(request_data):
    path = request_data.split(' ')[1]
    HDRS = 'HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=utf-8\r\n\r\n'
    HDRS_404 = 'HTTP/1.1 404 OK\r\nContent-Type: text/html; charset=utf-8\r\n\r\n'
    response = ' '
    try:
        with open('server/templates/' + path, 'rb') as file:
            response = file.read()
        return HDRS.encode('utf-8') + response
    except FileNotFoundError:
        return (HDRS_404 + 'Sorry, bro! Page not found...').encode('utf-8')

if __name__ == '__main__':
    start_my_server()