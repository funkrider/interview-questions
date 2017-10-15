(ns interview-questions.20-Gray-Code)

;; Determine if two integers have exactly one bit
;; difference. If they are the same or if they
;; have more than one bit difference the result should
;; be false.

;; e.g:
;; 001, 011 => true
;; 001, 010 => false
;; 000, 000 => false

;; XOR (001 011) => 010
;;

(defn count-bits [a]
  (loop [x a i 0]
    (if (= 0 x)
      i
      (recur (bit-shift-right x 1) (+ i (bit-and 1 x))))))

(defn is-power-of-2?
  "Binary trick: (bit-and a (- a 1)) => 0 when a is power of 2.
  e.g.  00100 && 00011 => 0. Note 0 is not a power of 2 but 1 is."
  [x]
  (if (= 0 x)
    false
    (= 0 (bit-and x (- x 1)))))

(defn is-gray-code-count-bits? [a b]
  (= 1 (count-bits (bit-xor a b))))

(defn is-gray-code? [a b]
  (is-power-of-2? (bit-xor a b)))