# Steve Jobs Academy - Programmazione 1

Questo repository contiene gli esercizi e i progetti realizzati durante il corso di **Programmazione 1** presso la Steve Jobs Academy. Gli esempi sono scritti in **Java** e coprono i concetti fondamentali della programmazione procedurale e ad oggetti.

## Struttura del Progetto

Il progetto è organizzato nelle seguenti cartelle e file:

- **[HelloWorld.java](HelloWorld.java)**: Il classico primo programma per verificare la corretta installazione dell'ambiente di sviluppo.
- **[SecretNumber/](SecretNumber/)**: Una serie di esercizi basati sul gioco dell'indovinare un numero segreto generato casualmente.
  - [SecretNumber_Basic.java](SecretNumber/SecretNumber_Basic.java): Versione base con input/output semplice.
  - [SecretNumber_If_Else.java](SecretNumber/SecretNumber_If_Else.java): Implementazione della logica decisionale per guidare l'utente.
  - [SecretNumber_Cicle_While.java](SecretNumber/SecretNumber_Cicle_While.java): Utilizzo del ciclo `while` per permettere tentativi infiniti finché non si indovina.
  - [SecretNumber_Cicle_For.java](SecretNumber/SecretNumber_Cicle_For.java): Utilizzo del ciclo `for` per limitare il numero di tentativi.
- **[Tris/](Tris/)**: Implementazioni del gioco del Tris (Tic-Tac-Toe).
  - [TrisNoArray.java](Tris/TrisNoArray.java): Una versione del Tris che sfida la logica non utilizzando array, gestendo ogni cella come una variabile separata.
  - [TrisNoArray_WithFunction.java](Tris/TrisNoArray_WithFunction.java): Evoluzione della versione precedente con l'introduzione delle funzioni (metodi) per migliorare la leggibilità e il riutilizzo del codice.

## Prerequisiti

Per eseguire questi file è necessario avere installato:
- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) versione 8 o superiore.

## Come Eseguire gli Esercizi

Puoi compilare ed eseguire ogni file Java utilizzando il terminale. Ad esempio, per il gioco del Tris:

```bash
# Compilazione
javac Tris/TrisNoArray.java

# Esecuzione
java Tris.TrisNoArray
```

---
*Corso di Programmazione 1 - Steve Jobs Academy*
