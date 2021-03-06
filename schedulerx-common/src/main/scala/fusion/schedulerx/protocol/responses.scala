/*
 * Copyright 2019 akka-fusion.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fusion.schedulerx.protocol

import fusion.json.jackson.CborSerializable

trait Response extends CborSerializable

case class ResponseResult(code: Int, message: String = "", data: Any = null) extends Response

object ResponseResult {
  val NotFound = error(404, "Not found.")
  val OK = ok(null)
  def ok(data: Any): ResponseResult = ResponseResult(200, "", data)
  def ok(data: Any, message: String): ResponseResult = ResponseResult(200, message, data)
  def error(code: Int): ResponseResult = ResponseResult(code)
  def error(code: Int, message: String): ResponseResult = ResponseResult(code, message)
}
