main=>
    A = read_int(),
    B = read_int(),
    C = read_int(),
    D = [[X,Y] : X in 1..C, Y in 1..C, A*X + B * Y = C],
    println(D.length),
    foreach([X,Y] in D)
        printf("%d %d%n", X, Y)
    end.