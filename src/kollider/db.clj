(ns kollider.db
  (:require [monger.core :as [mg]]
            [monger.collection :as [mc]])
  (:import
   org.bson.types.ObjectId
   [com.mongodb MongoOptions]))

(def mg-uri (env :db-uri "this is a test db"))

(defn with-conn [f]
  (let [conn-obj (mgconnect-via-uri mg-uri)
        res (f conn-obj)]
    (mg/disconnect (:conn conn-obj))
    res))

(defn get-by-id
  [coll id]
  (with-conn (fn [conn]
               (mc/find-one-as-map (:db conn) coll {:_id (ObjectId. id)}))))
