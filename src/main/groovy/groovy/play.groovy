package groovy

def test(Closure closure) {
    closure.run();
}

test{
    println "hello world!!!"
}




