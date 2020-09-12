function main (){
    const arr = [ [ 1, 2, [ 3 ] ], 4, 5, [ 6, [ 7, 8, [ 10, [ 9 ] ] ] ] ];
    let result = simplification(arr);
    console.log(result);
}

let new_arr = [];
function simplification(arr){
    if(Array.isArray(arr)){
       for(let index in arr){
           if( Array.isArray(arr[index])){
             simplification(arr[index]);
           }else{
               new_arr.push(arr[index]);
           }
       }
    }
    return new_arr;
}

main();
