function connectWebSocket() {
    const socket = new WebSocket('ws://localhost:8080/roomChat/chat');

    socket.addEventListener('open', function (event) {
        console.log('WebSocket connection opened');
    });

    socket.addEventListener('message', function (event) {
        console.log('Message received from server:', event.data);
    });

    function sendMessage(message) {
        if (socket.readyState === WebSocket.OPEN) {
            socket.send(message);
            console.log('Message sent to server:', message);
        } else {
            console.error('WebSocket connection is not open');
        }
    }

    return {
        sendMessage: sendMessage
    };
}

document.addEventListener('DOMContentLoaded', function() {
    const chatSocket = connectWebSocket();
    chatSocket.sendMessage('Hello, server!')
});