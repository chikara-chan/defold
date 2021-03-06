;; Copyright 2020 The Defold Foundation
;; Licensed under the Defold License version 1.0 (the "License"); you may not use
;; this file except in compliance with the License.
;; 
;; You may obtain a copy of the License, together with FAQs at
;; https://www.defold.com/license
;; 
;; Unless required by applicable law or agreed to in writing, software distributed
;; under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
;; CONDITIONS OF ANY KIND, either express or implied. See the License for the
;; specific language governing permissions and limitations under the License.

(ns editor.system
  (:require [clojure.java.io :as io]))

(set! *warn-on-reflection* true)

(def ^:private MB 1048576)

(defn rt-mem []
  (let [rt    (Runtime/getRuntime)
        total (.totalMemory rt)
        max   (.maxMemory rt)
        free  (.freeMemory rt)]
    {:total (int (/ total MB))
     :max   (int (/ max MB))
     :free  (int (/ free MB))
     :used  (int (/ (- total free) MB))}))

(defn mem-diff [before after]
  {:total (- (:total after) (:total before))
   :max   (- (:max after) (:max before))
   :free  (- (:free after) (:free before))
   :used  (- (:used after) (:used before))})

(defn os-name
  ^String []
  (System/getProperty "os.name"))

(defn os-arch
  ^String []
  (System/getProperty "os.arch"))

(defn os-version
  ^String []
  (System/getProperty "os.version"))

(defn defold-version
  ^String []
  (System/getProperty "defold.version"))

(defn defold-channel
  ^String []
  (System/getProperty "defold.channel"))

(defn defold-resourcespath
  ^String []
  (System/getProperty "defold.resourcespath"))

(defn defold-launcherpath
  ^String []
  (System/getProperty "defold.launcherpath"))

(defn defold-editor-sha1
  ^String []
  (System/getProperty "defold.editor.sha1"))

(defn set-defold-editor-sha1! [^String sha1]
  (assert (not-empty sha1))
  (System/setProperty "defold.editor.sha1" sha1))

(defn defold-engine-sha1
  ^String []
  (System/getProperty "defold.engine.sha1"))

(defn set-defold-engine-sha1! [^String sha1]
  (assert (not-empty sha1))
  (System/setProperty "defold.engine.sha1" sha1))

(defn defold-build-time
  ^String []
  (System/getProperty "defold.buildtime"))

(defn defold-dev? []
  (or (some? (System/getProperty "defold.dev"))
      (not (defold-version))))

(defn defold-unpack-path
  ^String []
  (System/getProperty "defold.unpack.path"))

(defn java-home
  ^String []
  (System/getProperty "java.home"))

(defn user-home
  ^String []
  (System/getProperty "user.home"))

(defn java-runtime-version
  ^String []
  (System/getProperty "java.runtime.version"))

(defonce mac? (-> (os-name)
                  (.toLowerCase)
                  (.indexOf "mac")
                  (>= 0)))
