
function Test (a, b, c, d){
    this.a = a;
    this.b = b;
    this.c = function (){
       return c + " " + c;
    }
    this.d = function f() {
        return d + " d";
    }
}

function main(){
    AF15 = "x0D801";
    d = AF15;
    ED81 = "0x701"
    ED81 += "bA65";
    e = ED81;
    let t = new Test("1", 2, "c", d);
    Test.prototype.e = (e) => {
        return e + " e-" + e;
    };
    console.log(Test); 
    console.log(t);
    console.log(t.a);
    console.log(t.b);
    console.log(t.c());
    console.log(t.d());
    console.log(t.e(e));
}

main();