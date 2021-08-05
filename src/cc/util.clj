(ns cc.util)

(import java.util.Calendar)
(import java.text.SimpleDateFormat)

(defn date-from [d m y]
  (.getTime (doto (Calendar/getInstance)
              (.setTimeInMillis 0)
              (.set y (- m 1) d 0 0 0))))

(defn get-month-from-compra [item]
  (.format (SimpleDateFormat. "MMMMM/yyyy") (item :data)))
