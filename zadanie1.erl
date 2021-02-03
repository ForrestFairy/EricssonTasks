-module(zadanie1).
-export([change/1]).

change(File) -> 
    {ok, Binary} = file:read_file(File),
    split_binary(Binary).

split_binary(<<ID:4, Msg:3, Check:1, Tail/binary>>) ->
    {ID, Msg, Check, Tail}.