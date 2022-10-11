# ElevadorEsqui-PPC
Trabalho de Programação Paralela e Concorrente

Este trabalho tem como objetivo simular o controle do fluxo de passagem de
esquiadores num elevador de uma pista de esqui. Esse elevador tem a capacidade de
levar no máximo 4 pessoas e no mínimo 3. 

## O que foi usado?
O nosso trabalho usa a versão 17 do Java e deve ser executado na IDE do Intellij. Ao
executar, é possível ver as filas de esquiadores e o elevador passando tirando sempre
esquiadores dessas filas.
O trabalho todo foi feito em conjunto, cada um dando ideias de como melhorar cada
funcionalidade do nosso projeto, mas para manter por escrito: O Patrick implementou a
classe Esquiador, Filas e a Taxa de Aproveitamento, e a Natália implementou a classe
Elevador, Main e as Taxas de tempo de espera em fila, ambos implementaram
correções no programa após a finalização.

## Conclusão
Podemos concluir que esse projeto serviu de grande aprendizado de programação
concorrente, pois treinamos a concorrência de dois processos que desejam utilizar do mesmo
recurso. Os dois processos são a classe de Esquiador e a classe de Elevador, e o mesmo
recurso utilizado seria as pessoas que são inseridas e retiradas das filas.
Desse modo, para fazermos essa concorrência não precisa necessariamente transformar os
processos em implementadas com Threads ou Runnable. Podemos apenas programar normal
de forma bem estruturada, e assim, buscar conhecimento de novas funcionalidades do Java
que facilite a concorrência de processos, como a classe Timer que permitiu a execução a cada
tempo desejado.
Por fim, percebemos quão importante é essa Programação Paralela e Concorrente nas
máquinas do nosso dia a dia. Um simples Elevador de Esquiadores precisa funcionar
perfeitamente bem, para não ocorrer Deadlock e Starvation, no caso real, acidentes.

