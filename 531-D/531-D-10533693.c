main=>
    N = read_int(),
    X = 1..1000,
    while(N > 0)
        A = read_int(),
        B = read_int(),
        X := [Y : Y in X, (Y > B || Y < A)],
        N := N - 1
    end,
    printf("%d", X.length),
    foreach(C in X)
        printf(" %d", C)
    end.