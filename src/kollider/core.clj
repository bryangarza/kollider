(ns kollider.core
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))

; ;; using MongoOptions allows fine-tuning connection parametersm
; ;; like automatic reconnection (highly recommended for production environment)
; (let [^MongoOptions opts (mg/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
;       ^ServerAddress sa  (mg/server-address "127.0.0.1" 27017)
;       conn               (mg/connect sa opts)])

(let [conn (mg/connect)
      db   (mg/get-db conn "monger-test")])
