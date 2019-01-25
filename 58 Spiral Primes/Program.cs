using System;
using System.Collections.Generic;
using System.Linq;

namespace _58_Spiral_Primes
{
    class Program
    {
        static void Main(string[] args)
        {

            IDictionary<int, List<Number>> pfade = new Dictionary<int, List<Number>>();
            
            pfade.Add(1, new List<Number>() {new Number(3,2)});
            pfade.Add(2, new List<Number>() {new Number(5,4)});
            pfade.Add(3, new List<Number>() {new Number(7,6)});
            pfade.Add(4, new List<Number>() {new Number(9,8)});

            while(PercentPrimes(pfade) >= 10)
                AddLayer(pfade);

            Console.WriteLine($"Seitenlänge ist {SeitenLange(pfade)}");
        }

        static void AddLayer(IDictionary<int, List<Number>> pfade)
        {
            foreach(var pfad in pfade)
            {
                var letzterEintrag = pfad.Value.LastOrDefault();
                var newSummand = letzterEintrag.ActualSummand + 8;
                pfad.Value.Add(new Number(letzterEintrag.Value + newSummand, newSummand));
            }
        }

        static int SeitenLange(IDictionary<int, List<Number>> pfade)
        {
            return (pfade.FirstOrDefault().Value.Count() * 2) + 1;
        }

        static decimal PercentPrimes(IDictionary<int, List<Number>> pfade) 
        {
            List<Number> numbers = new List<Number>();

            foreach(var pfad in pfade)
            {
                numbers.AddRange(pfad.Value);
            }

            return (numbers.Where(n => n.Prime).Count()) * 100 / (numbers.Count());
        }
    }

    class Number
    {
        public int ActualSummand {get; set;}

        public int Value {get; set;}

        public bool Prime {get; set;}

        public override string ToString()
        {
            return Value.ToString();
        }

        public Number(int value, int actuellerSummand)
        {
            Value = value;
            ActualSummand = actuellerSummand;
            Prime = IsPrime(value);       
        }

        private bool IsPrime(int number)
        {
            if (number <= 1) return false;
            if (number == 2) return true;
            if (number % 2 == 0) return false;

            var boundary = (int)Math.Floor(Math.Sqrt(number));

            for (int i = 3; i <= boundary; i+=2)
                if (number % i == 0)
                    return false;

            return true;        
        }
    }
}
