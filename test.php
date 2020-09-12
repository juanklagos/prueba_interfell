<?php
function main (){
    $arr = [ [ 1, 2, [ 3 ] ], 4, 5, [ 6, [ 7, 8, [ 10, [ 9 ] ] ] ] ];
    $result = simplification($arr);
    var_dump($result);
}

function simplification($arr){
    $new_arr = [];
    if(is_array($arr)){
       foreach ($arr as $item) {
           if (is_array($item)) {
               $new_arr = array_merge($new_arr, simplification($item));
           }else {
               $new_arr[] = $item;
           }
       }
    }
  return $new_arr;
}
main();
