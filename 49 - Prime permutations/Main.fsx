let inline interessanteTeiler p =
    let nats =
        Seq.unfold (fun n -> Some (n,n + LanguagePrimitives.GenericOne)) (LanguagePrimitives.GenericOne + LanguagePrimitives.GenericOne)
    Seq.takeWhile (fun d -> d * d <= p) nats
let isPrime p =
    interessanteTeiler p
    |> Seq.forall (fun d -> p % d <> 0)

let isPermutation (str1:string) (str2:string) =
    let sortet1 = 
        str1
        |>Seq.sort

    let sortet2 = 
        str1
        |>Seq.sort

    Seq.forall2 (=) sortet1 sortet2 && Seq.length sortet1  = Seq.length sortet2 

let rec getNextPrime p =
    if isPrime p then
        p
    else
        getNextPrime p + 1

let rec getPrimes (n : int) (ls : List<int>) = 
    if n > 9999 then
        []
    else
        ls :: getNextPrime n


let makeSeq = 
    let seq = []
    (getPrimes 1000 seq)