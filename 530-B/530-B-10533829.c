main=>
    A = read_line(),
    D = reverse(A),
    L = length(D),
    B = slice(D, 1, L//2),
    C = slice(D, L//2+1, L),
    print(C),
    println(B)