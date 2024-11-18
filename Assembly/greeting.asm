section .data
    prompt db 'Enter your name: ', 0         ; Prompt for user input
    promptLen equ $-prompt
    greeting db 'Hello, ', 0                 ; Greeting message
    newline db 10, 0                         ; Newline character

section .bss
    name resb 50                             ; Reserve space for the name (50 bytes)
    message resb 100                         ; Reserve space for the final message (100 bytes)

section .text
    global _start

_start:
    ; Display the prompt
    call display_prompt

    ; Get user input
    call get_input

    ; Build the greeting message
    call build_greeting

    ; Display the greeting
    call display_greeting

    ; Exit the program
    mov eax, 1          ; sys_exit
    xor ebx, ebx        ; Exit code 0
    int 0x80

display_prompt:
    ; Write the prompt to stdout
    mov eax, 4          ; sys_write
    mov ebx, 1          ; stdout
    mov ecx, prompt     ; Address of prompt
    mov edx, promptLen  ; Length of the prompt
    int 0x80
    ret

get_input:
    ; Read user input into the name buffer
    mov eax, 3          ; sys_read
    mov ebx, 0          ; stdin
    mov ecx, name       ; Address of name buffer
    mov edx, 50         ; Maximum input length
    int 0x80

    ; Replace the newline character with null terminator
    mov ecx, name
    .loop:
        cmp byte [ecx], 10     ; Check for newline
        je .done
        cmp byte [ecx], 0      ; Check for null terminator
        je .done
        inc ecx
        jmp .loop
    .done:
        mov byte [ecx], 0      ; Replace with null terminator
    ret

build_greeting:
    ; Clear the message buffer
    mov edi, message
    mov ecx, 100
    xor eax, eax
    rep stosb                  ; Fill buffer with zeros

    ; Build the greeting message
    mov edi, message           ; Destination buffer
    mov esi, greeting          ; Source buffer
    call string_copy

    mov esi, name              ; Append user name
    call string_copy

    mov esi, newline           ; Append newline
    call string_copy
    ret

display_greeting:
    ; Display the final greeting message
    mov eax, 4                 ; sys_write
    mov ebx, 1                 ; stdout
    mov ecx, message           ; Address of message
    mov edx, 100               ; Maximum message buffer length
    int 0x80
    ret

string_copy:
    ; Copy a null-terminated string from esi to edi
    .loop:
        lodsb                  ; Load byte from esi into al
        test al, al            ; Check if null terminator
        jz .done               ; Exit if null terminator
        stosb                  ; Store byte into edi
        jmp .loop
    .done:
    ret
