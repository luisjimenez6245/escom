
main: 
      addi  $v0, $zero, 4     # Se usará el servicio 4
      la    $a0, cadena       # Se obtiene el argumento 
      syscall                 # Solicita el servicio 
      jr    $31               # Termina la función principal       
      .data      
cadena: .asciiz   "¡¡ Hola Mundo !!" 