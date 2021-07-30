(ns cc.util)

(import java.util.Calendar)

(defn date-from [d m y]
  (.getTime (doto(Calendar/getInstance)
              (.setTimeInMillis 0)
              (.set y (- m 1) d 0 0 0))))

(import java.text.DateFormatSymbols)

(import java.text.DateFormatSymbols)
(defn get-month-from-compra [item]
  ((vec (.getMonths (DateFormatSymbols/getInstance) ) )  (.getMonth (item :data))))
