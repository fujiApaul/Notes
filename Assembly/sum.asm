; only accurately works wwhen sum is from 0 to 9

section .text

global _start

_start:
    ; Step 1: Load the first number (x) into eax and convert it from ASCII to integer
    mov     eax, [x]       ; Load the value of x ('5') into eax
    sub     eax, '0'       ; Convert ASCII '5' to its integer value (5)

    ; Step 2: Load the second number (y) into ebx and convert it from ASCII to integer
    mov     ebx, [y]       ; Load the value of y ('3') into ebx
    sub     ebx, '0'       ; Convert ASCII '3' to its integer value (3)

    ; Step 3: Add the two numbers
    add     eax, ebx       ; eax = 5 + 3 = 8

    ; Step 4: Convert the sum back to ASCII
    add     eax, '0'       ; Convert integer 8 to ASCII '8'

    ; Step 5: Store the ASCII sum in the `sum` variable
    mov     [sum], eax     ; Store '8' (ASCII) into sum

    ; Step 6: Print the message "sum of x and y is "
    mov     ecx, msg       ; Load the address of the message string into ecx
    mov     edx, len       ; Load the length of the message into edx
    mov     ebx, 1         ; Set file descriptor 1 (stdout)
    mov     eax, 4         ; System call 4: sys_write
    int     0x80           ; Make the system call to print the message

    ; Step 7: Print the result (sum)
    mov     ecx, sum       ; Load the address of the sum (ASCII '8') into ecx
    mov     edx, 1         ; Length of the sum is 1 character
    mov     ebx, 1         ; Set file descriptor 1 (stdout)
    mov     eax, 4         ; System call 4: sys_write
    int     0x80           ; Make the system call to print the sum

    ; Step 8: Exit the program
    mov     eax, 1         ; System call 1: sys_exit
    int     0x80           ; Make the system call to terminate the program

section .data
    x db '5'               ; First number as ASCII character '5'
    y db '3'               ; Second number as ASCII character '3'
    msg db "sum of x and y is " ; Message to print
    len equ $ - msg        ; Calculate length of the message at assembly time

section .bss
    sum resb 1             ; Reserve 1 byte for the result (sum in ASCII)
