# P2P-Chat

This project is a simple client-server application that allows clients to query a server for course names using either TCP or UDP protocols. The server searches for the course number in a text file and returns the stored course name or an error message if the course number is not found.

## Usage

1. Run the server program (either `mainTCP_server` or `mainUDP_server`) on a machine that is accessible to clients.
2. Run the client program (either `mainTCP_client` or `mainUDP_client`) on a separate machine and enter the IP address of the server when prompted.
3. Enter a course number when prompted by the client program. The server will respond with the stored course name or an error message if the course number is not found.
4. To exit the client program, enter `EXIT` (for TCP) or `exit` (for UDP) when prompted for a course number.

## Requirements

- Java 8 or higher
- A text file containing course numbers and names located at `C:\\Users\\muja\\IdeaProjects\\network\\src\\mytxt.txt` on the server machine.
