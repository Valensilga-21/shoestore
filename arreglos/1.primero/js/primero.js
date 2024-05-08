/**
 * Primer ejercicio con arreglos
 * Autor:JR
 * 26 de abril de 2024
 */

let arregloNumeros=[];
let arregloFrutas = [];
let iteracion;
let consecutivo=0;

arregloNumeros=[1,2,3,4,5,6];
arregloFrutas = ['banana','fresa','papaya','limon','uva'];

let sizeArrayNum = arregloNumeros.length;
let sizeArrayFruit = arregloFrutas.length;

console.log("cantidad numeros " +sizeArrayNum);
console.log("Cantidad frutas "+sizeArrayFruit);

console.log(arregloFrutas);
console.log(arregloFrutas[3]);

arregloFrutas.push('Manzana');
sizeArrayFruit= arregloFrutas.length;
console.log("cantidad frutas "+sizeArrayFruit);

console.log(arregloFrutas);
console.log(arregloFrutas[5]);

for(iteracion=0;iteracion<sizeArrayFruit;iteracion++){
    consecutivo++
    console.log(consecutivo+":"+arregloFrutas[iteracion]);
}



