.data            # Zona de datos
#####
      .text      # Zona de instrucciones
main: li $v0, 1  # Llamada al sistema para print int
      addi $s0, $a0, 0
      syscall
      addi $s1, $a0, 1
      syscall
      addi $s2, $a0, 1
      syscall
      
      # addi $a0, $s0, 1
      # syscall    # Muestra el segundo número en pantalla
loop: 
      li $s2, 1
      syscall

      addi $s0, $s0, $s1
      addi $s0, $zero, $s1
      addi $s1, $zero, $s2
      addi $s2, $s1, $s0

      syscall
      ble $s2, 20, loop
      # syscall

      li $v0, 10 # Finalizarprograma
      syscall