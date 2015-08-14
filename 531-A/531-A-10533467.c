main=>
    A = read_int(),
    B = read_int(),
    C = read_int(),
    if  (A < 0) then
        A := -A,
        B := -B,
        C := -C
    end,
    D = B*B - 4 * A * C,
    printf("%f", (-B - sqrt(D))/(2*A)),
    if(D > 0) then
        printf(" %f", (-B + sqrt(D))/(2*A))
    end.