(ns interview-questions.15-Rotate-bits)

;;; Given a number write a function to rotate
;;; the bits. Positive is to the left negative
;;; is to the right.

;;; Take bits as an input also

;;; e.g. 101011001 2 -> 101100110

;;; Twos complement means that you may potentially
;;; change the sign to be neg from pos, but hey
;;; the number will be completely changed anyway!

;;; Shift left - will drop bits on the right
;;; Shift them back right and do an OR will add the bits together

;;; Clojure uses java.lang.Long as integer base 64 bits

(defn rotate-bit [x n bits]
  (let [shift (if (pos-int? n) bit-shift-left
                               bit-shift-right)
        dropped (if (pos-int? n) bit-shift-right
                                 bit-shift-left)
        n-abs (mod (Math/abs n) bits)]
  (bit-or (shift x n-abs) (dropped x (- bits n-abs))))
  )