const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
    // Serve HTML page
    if (req.url === '/') {
        fs.readFile('index.html', 'utf8', (err, data) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end('Internal Server Error');
                return;
            }
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.end(data);
        });
    }
    // Handle SSE requests
    else if (req.url === '/sse-endpoint') {
        res.writeHead(200, {
            'Content-Type': 'text/event-stream',
            'Cache-Control': 'no-cache',
            'Connection': 'keep-alive'
        });

        // Send messages to clients every 2 seconds
        const interval = setInterval(() => {
            const message = `Server time: ${new Date().toLocaleTimeString()}`;
            res.write(`data: ${message}\n\n`);
        }, 2000);

        // Close the SSE connection after 10 seconds
        setTimeout(() => {
            clearInterval(interval);
            res.end();
        }, 10000);
    }
    // Serve other files
    else {
        fs.readFile(req.url.substring(1), (err, data) => {
            if (err) {
                res.writeHead(404, { 'Content-Type': 'text/plain' });
                res.end('Not Found');
                return;
            }
            res.writeHead(200);
            res.end(data);
        });
    }
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}/`);
});
