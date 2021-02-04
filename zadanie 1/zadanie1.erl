-module(zadanie1).
-export([convert/1]).

convert(File) ->
    {ok, Binary} = file:read_file(File),
    List = process_objects(Binary),
    % now there is a list o bitstrings
    {All, Bad, ListOfGood} = count_objects(List),
    % if there is no output.txt this will create it
    % if there is just updates
    {ok, Output} = file:open("output.txt", [write]),
    io:fwrite(Output, "~p\n~p\n~s", [All, Bad, ListOfGood]).

process_objects(Binary) -> process_objects(split_binary(Binary, 8), []).

process_objects({Object, Rest}, List) when size(Rest) < 1 -> List ++ [Object];
process_objects({Object, Rest}, List) ->
    process_objects(split_binary(Rest, 8), List ++ [Object]).

count_objects(List) -> 
    count_objects(List, 0, 0, []).

count_objects([], All, Bad, ListOfGood) ->
    {All, Bad, ListOfGood};

count_objects([Head | Tail], All, Bad, ListOfGood) ->
    case is_good(binary_to_list(Head)) of
        false -> 
            count_objects(Tail, All + 1, Bad + 1, ListOfGood);
        true ->
            % need to check if [List|Head] is fine
            count_objects(Tail, All + 1, Bad, ListOfGood ++ [Head])
        end.

% if all message bits are equal to 48 = '0' it's bad object
is_good([_, _, _, _, 48, 48, 48, _]) ->
    false;
% last bit of id indicates if it's even or odd
% so it need to be the same as check bit
is_good([_, _, _, Check, _, _, _, Check]) -> 
    true;
is_good(_Object) ->
    false.