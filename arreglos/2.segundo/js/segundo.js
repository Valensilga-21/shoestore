/**
 * Segundo Ejercicio de arreglos,creando matrices
 * Autor: JR
 * 26 de abril del 2024
 */

let matriz=[];
let iteracion1;
let iteracion2;

matriz=[
    ['manzana', 'pera','uva','sandia'],
    ['cebolla', 'tomate', 'acelga'],
    ['papa sabanera','papa pastusa', 'papa criolla'],
]
console.log (matriz);
console.log(matriz[2][2]);
console.log(matriz.length);

for(iteracion1=0;iteracion1<matriz.length;iteracion1++){
    for(iteracion2=0;iteracion2<matriz[iteracion1].length;iteracion2++){
    console.log(matriz[iteracion1][iteracion2]);
    }

}