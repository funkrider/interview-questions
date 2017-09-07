(ns interview-questions.01-FizzBuzz-test
  (:require [clojure.test :refer :all]
            [interview-questions.01-FizzBuzz :refer :all]))


(testing "Helper Functions"
  (is (true? (divisible-by? 2 4)))
  (is (true? (divisible-by? 3 6)))

  (is (false? (divisible-by? 2 5)))
  (is (false? (divisible-by? 3 5)))

  (is (false? (divisible-by? nil nil)))
  (is (false? (divisible-by? 1 nil)))
  (is (false? (divisible-by? nil 1)))

  (is (false? (divisible-by? 0 nil)))
  (is (false? (divisible-by? nil 0)))
  (is (false? (divisible-by? 0 0)))

  (is (false? (divisible-by? 0 1)))
  (is (false? (divisible-by? 1 0)))
  (is (false? (divisible-by? 0 0)))

  (is (= (take 10 (positive-numbers))
        '(1 2 3 4 5 6 7 8 9 10)))

  )

(testing "Fizz-buzz"
  (is (= (fizz-buzz 15)
        '(1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" 13 14 "fizzbuzz"))))