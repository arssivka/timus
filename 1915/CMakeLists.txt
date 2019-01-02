cmake_minimum_required(VERSION 3.0)
project(1915)

set(CMAKE_CXX_STANDARD "17")

file(GLOB_RECURSE SRCS "src/*.cpp" "src/*.h")
add_executable(${CMAKE_PROJECT_NAME} ${SRCS})